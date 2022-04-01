package com.zlz.website.blog.common.transfer;

import com.zlz.basic.constants.BasicConstants;
import com.zlz.basic.enums.DeletedStatusEnum;
import com.zlz.basic.response.TreeNode;
import com.zlz.route.common.trace.TraceContext;
import com.zlz.website.blog.common.dos.CategoryDO;
import com.zlz.website.blog.common.dtos.CategoryDTO;
import com.zlz.website.blog.common.enums.category.IsPublishEnum;
import com.zlz.website.blog.common.req.category.CategoryUpdateReq;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author zhulinzhong
 * @date 2022-03-30 17:14:01
 */
public class CategoryTransfer {

    public static CategoryDTO trans2CategoryDTO(CategoryDO category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getTitle());
        dto.setCreatedTime(category.getCreatedTime());
        dto.setLastModifiedTime(category.getLastModifiedTime());
        return dto;
    }

    public static TreeNode<CategoryDTO> trans2CategoryDTOTreeNode(CategoryDO category) {
        TreeNode<CategoryDTO> treeNode = new TreeNode<>();
        treeNode.setId(category.getId());
        treeNode.setName(category.getTitle());
        treeNode.setPId(category.getParentId());
        treeNode.setData(trans2CategoryDTO(category));
        treeNode.setChildren(new ArrayList<>());
        return treeNode;
    }

    public static CategoryDO buildCategoryDO(CategoryUpdateReq req) {
        Date now = new Date();
        CategoryDO category = new CategoryDO();
        category.setId(req.getId());
        category.setParentId(BasicConstants.ZERO_LONG);
        if (req.getParentId() != null) {
            category.setParentId(req.getParentId());
        }
        category.setTitle(req.getName());
        category.setIntroduction(req.getIntroduction());
        category.setImageUrl(req.getImageUrl());
        category.setIsPublish(IsPublishEnum.PUBLISHED.getCode());
        category.setIsDeleted(DeletedStatusEnum.NOT_DELETED.getCode());
        if (req.getIsPublish() != null) {
            category.setIsPublish(req.getIsPublish());
        }
        category.setCreator(TraceContext.getUserId());
        category.setCreatedTime(now);
        category.setLastModifier(TraceContext.getUserId());
        category.setLastModifiedTime(now);
        return category;
    }


}
