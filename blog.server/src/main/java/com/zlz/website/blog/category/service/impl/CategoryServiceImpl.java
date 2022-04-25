package com.zlz.website.blog.category.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlz.basic.constants.BasicConstants;
import com.zlz.basic.enums.DeletedStatusEnum;
import com.zlz.basic.response.ResultSet;
import com.zlz.basic.response.TreeNode;
import com.zlz.basic.trace.TraceContext;
import com.zlz.website.blog.category.mapper.CategoryMapper;
import com.zlz.website.blog.category.service.CategoryService;
import com.zlz.website.blog.common.dos.CategoryDO;
import com.zlz.website.blog.common.dtos.CategoryDTO;
import com.zlz.website.blog.common.exception.BlogBizException;
import com.zlz.website.blog.common.exception.BlogExceptionEnum;
import com.zlz.website.blog.common.param.CategoryParam;
import com.zlz.website.blog.common.req.category.CategoryQueryReq;
import com.zlz.website.blog.common.req.category.CategoryUpdateReq;
import com.zlz.website.blog.common.transfer.CategoryTransfer;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:51:16
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Integer LEVEL_CODE_SIZE = 4;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ResultSet<Long> updateCategory(CategoryUpdateReq req) {
        CategoryDO categoryDO = CategoryTransfer.buildCategoryDO(req);

        // 重名校验
        QueryWrapper<CategoryDO> wrapper = new QueryWrapper<>();
        wrapper.eq("title", req.getName());
        wrapper.eq("is_deleted", DeletedStatusEnum.NOT_DELETED.getCode());
        wrapper.last("limit 1");
        CategoryDO sameName = categoryMapper.selectOne(wrapper);
        if (sameName != null && !sameName.getId().equals(req.getId())) {
            throw new BlogBizException(BlogExceptionEnum.MODIFY_BLOG_ERROR_SAME_TITLE);
        }

        // 新增分类
        if (categoryDO.getId() == null || BasicConstants.ZERO_LONG.equals(categoryDO.getId())) {
            return createCategory(categoryDO);
        }

        return doUpdateCategory(categoryDO);
    }

    @Override
    public ResultSet<List<CategoryDTO>> listCategory(CategoryQueryReq req) {

        CategoryParam param = new CategoryParam();
        param.setId(req.getId());
        param.setTitle(req.getName());
        param.setCreator(TraceContext.getUserId());
        param.setLevelCode(req.getLevelCode());

        List<CategoryDO> categories = categoryMapper.selectListByParams(param);
        if (CollectionUtils.isEmpty(categories)) {
            return ResultSet.success();
        }

        List<CategoryDTO> categoryList = categories.stream().map(CategoryTransfer::trans2CategoryDTO).collect(Collectors.toList());
        return ResultSet.success(categoryList);
    }

    @Override
    public ResultSet<List<TreeNode<CategoryDTO>>> listCategoryTree(CategoryQueryReq req) {
        CategoryParam param = new CategoryParam();
        param.setTitle(req.getName());
        param.setLevelCode(req.getLevelCode());
        param.setCreator(TraceContext.getUserId());

        List<CategoryDO> categories = categoryMapper.selectListByParams(param);
        if (categories.isEmpty()) {
            return ResultSet.success();
        }
        Map<Long, List<CategoryDO>> groupByParentId = categories.stream().collect(Collectors.groupingBy(CategoryDO::getParentId));
        List<CategoryDO> parentCategories = groupByParentId.get(BasicConstants.ZERO_LONG);
        List<TreeNode<CategoryDTO>> data = parentCategories.stream().map(CategoryTransfer::trans2CategoryDTOTreeNode).collect(Collectors.toList());
        buildChildTreeNode(data, groupByParentId);
        return ResultSet.success(data);
    }

    @Override
    public ResultSet<Long> softDeleteCategory(Long id) {

        // 存在子级不允许删除
        CategoryDO childCate = categoryMapper.selectByParentId(id, TraceContext.getUserId());
        if (childCate != null) {
            throw new BlogBizException(BlogExceptionEnum.DELETE_BLOG_ERROR);
        }

        // 逻辑删除
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setId(id);
        categoryDO.setIsDeleted(DeletedStatusEnum.DELETED.getCode());
        categoryDO.setLastModifier(TraceContext.getUserId());
        categoryDO.setLastModifiedTime(new Date());
        categoryMapper.updateById(categoryDO);
        return ResultSet.success(id);
    }

    private ResultSet<Long> doUpdateCategory(CategoryDO categoryDO) {
        CategoryDO update = new CategoryDO();
        update.setId(categoryDO.getId());
        update.setTitle(categoryDO.getTitle());
        categoryMapper.updateById(update);
        return ResultSet.success(categoryDO.getId());
    }

    private ResultSet<Long> createCategory(CategoryDO categoryDO) {
        // 查询父级和同级最大的levelCode
        CategoryDO parentCate = null;
        if (categoryDO.getParentId() != null && !BasicConstants.ZERO_LONG.equals(categoryDO.getParentId())) {
            parentCate = categoryMapper.selectByPrimaryKey(categoryDO.getParentId(), TraceContext.getUserId());
        }
        CategoryDO brotherCate = categoryMapper.selectByParentId(categoryDO.getParentId(), TraceContext.getUserId());

        // 构建levelCode
        buildLevelCode(categoryDO, parentCate, brotherCate);
        categoryMapper.insert(categoryDO);
        return ResultSet.success(categoryDO.getId());
    }

    private void buildLevelCode(CategoryDO category, CategoryDO parentCate, CategoryDO brotherCate) {
        // 第一个一级分类
        if (parentCate == null && brotherCate == null) {
            category.setLevelCode(appendZero(1));
            category.setLevel(1);
            return;
        }

        // 一级分类
        if (parentCate == null) {
            category.setLevel(brotherCate.getLevel());
            category.setLevelCode(appendZero(Integer.parseInt(brotherCate.getLevelCode()) + 1));
            return;
        }

        // 父级的第一个子集
        if (brotherCate == null) {
            category.setLevelCode(parentCate.getLevelCode() + appendZero(1));
            category.setLevel(parentCate.getLevel() + 1);
            return;
        }

        // 存在兄弟节点的子集
        String brotherLevelCode = brotherCate.getLevelCode();
        String before = brotherLevelCode.substring(0, brotherLevelCode.length() - LEVEL_CODE_SIZE);
        String after = brotherLevelCode.substring(brotherLevelCode.length() - LEVEL_CODE_SIZE);
        category.setLevelCode(before + appendZero(Integer.parseInt(after) + 1));
        category.setLevel(brotherCate.getLevel());
    }

    private String appendZero(Integer num) {
        String sNum = String.valueOf(num);
        if (sNum.length() >= LEVEL_CODE_SIZE) {
            return sNum;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < LEVEL_CODE_SIZE - sNum.length(); i++) {
            str.append("0");
        }
        return str.append(sNum).toString();
    }

    private void buildChildTreeNode(List<TreeNode<CategoryDTO>> parent, Map<Long, List<CategoryDO>> groupByParentId) {
        if (parent.isEmpty()) {
            return;
        }
        for (TreeNode<CategoryDTO> treeNode : parent) {
            List<CategoryDO> categories = groupByParentId.get(treeNode.getId());
            if (CollectionUtils.isEmpty(categories)) {
                continue;
            }
            List<TreeNode<CategoryDTO>> children =
                    categories.stream()
                            .map(CategoryTransfer::trans2CategoryDTOTreeNode)
                            .collect(Collectors.toList());
            buildChildTreeNode(children, groupByParentId);
            treeNode.setChildren(children);
        }
    }
}
