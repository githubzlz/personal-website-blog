package com.zlz.website.blog.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.zlz.basic.constants.BasicConstants;
import com.zlz.basic.enums.DeletedStatusEnum;
import com.zlz.basic.response.ResultSet;
import com.zlz.basic.trace.TraceContext;
import com.zlz.website.blog.blog.BlogBuilder;
import com.zlz.website.blog.blog.mapper.BlogContentMapper;
import com.zlz.website.blog.blog.mapper.BlogMapper;
import com.zlz.website.blog.blog.service.BlogService;
import com.zlz.website.blog.common.dos.BlogContentDO;
import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.dtos.BlogDTO;
import com.zlz.website.blog.common.enums.blog.EditorTypeEnum;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import com.zlz.website.blog.common.req.blog.BlogListQueryReq;
import com.zlz.website.blog.common.transfer.BlogTransfer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:09:24
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;
    private final BlogContentMapper blogContentMapper;

//    private final CategoryService categoryService;

    public BlogServiceImpl(BlogMapper blogMapper, BlogContentMapper blogContentMapper) {
        this.blogMapper = blogMapper;
        this.blogContentMapper = blogContentMapper;
//        this.categoryBlogManageService = categoryBlogManageService;
    }

    @Override
    public ResultSet<List<BlogDTO>> queryList(BlogListQueryReq req) {
        req.getParams().setCreator(TraceContext.getUserId());
        List<BlogDO> blogDOS;
        if(!DeletedStatusEnum.DELETED.getCode().equals(req.getParams().getIsDeleted())){
            req.getParams().setIsDeleted(DeletedStatusEnum.NOT_DELETED.getCode());
        }
        if (StringUtils.isNotEmpty(req.getParams().getAll())) {
            blogDOS = blogMapper.selectListByParamAll(req.getParams(), req.getPageInfo());
        } else {
            blogDOS = blogMapper.selectListByParams(req.getParams(), req.getPageInfo());
        }
        List<BlogDTO> result = blogDOS.stream().map(BlogTransfer::trans2BlogDTO).collect(Collectors.toList());
        return ResultSet.success(result);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultSet<Long> createBlog(BlogEditReq req) {
        Date date = new Date();
        BlogDO blog = BlogBuilder.buildBlogDO(req, date);
        blogMapper.insert(blog);

        BlogContentDO blogContent = BlogBuilder.buildBlogContentDO(blog.getId(), req.getBlogContent(), date);
        if (EditorTypeEnum.EDITOR_MD.getType().equals(blogContent.getEditorType())) {
            blogContent.setContentMd(req.getBlogContent().getContent());
        }
        blogContentMapper.insert(blogContent);

//        categoryBlogManageService.getBlogByTagIds()
        return ResultSet.success(blog.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultSet<Long> modifyBlog(BlogEditReq req) {
        Long blogId = req.getId();
        Date date = new Date();
        if (req.getId() != null) {
            BlogDO blog = BlogBuilder.buildBlogDO(req, date);
            blogMapper.updateById(blog);
        }

        // 存在更新
        // 1.获取最后版本
        // 2.将最后版本置为无效
        // 3.插入新版本
        if (req.getId() != null) {
            BlogContentDO blogContent = BlogBuilder.buildBlogContentDO(blogId, req.getBlogContent(), date);
            BlogContentDO oldBlogContent = blogContentMapper.selectLastVersionByBlogId(blogId);
            blogContentMapper.realDeleteById(oldBlogContent.getId());

            blogContent.setVersion(oldBlogContent.getVersion() + 1);
            blogContentMapper.insert(blogContent);

        }
        return ResultSet.success(blogId);
    }

    @Override
    public ResultSet<Boolean> softDeleteBlog(Long blogId) {
        // 修改blog
        BlogDO blogDO = new BlogDO();
        blogDO.setId(blogId);
        blogDO.setIsDeleted(DeletedStatusEnum.DELETED.getCode());
        blogDO.setOperator(TraceContext.getUserId());
        blogDO.setModifiedTime(new Date());
        int update = blogMapper.updateById(blogDO);
        if (BasicConstants.ZERO_INTEGER.equals(update)) {
            return ResultSet.error();
        }

        // 修改content
        BlogContentDO blogContentDO = new BlogContentDO();
        blogContentDO.setIsDeleted(DeletedStatusEnum.DELETED.getCode());
        blogContentDO.setOperator(TraceContext.getUserId());
        blogContentDO.setModifiedTime(new Date());
        UpdateWrapper<BlogContentDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("blog_id", blogId);
        update = blogContentMapper.update(blogContentDO, updateWrapper);
        if (BasicConstants.ZERO_INTEGER.equals(update)) {
            return ResultSet.error();
        }
        return ResultSet.success();
    }

    @Override
    public ResultSet<Boolean> deleteBlog(Long blogId) {
        int i = blogMapper.deleteById(blogId);
        if (BasicConstants.ZERO_INTEGER.equals(i)) {
            return ResultSet.error();
        }
        return ResultSet.success();
    }

    @Override
    public ResultSet<Long> updatePublish(BlogEditReq req) {
        BlogDO blogDO = new BlogDO();
        blogDO.setId(req.getId());
        blogDO.setIsPublish(req.getIsPublish());
        int i = blogMapper.updateById(blogDO);
        if (BasicConstants.ZERO_INTEGER.equals(i)) {
            return ResultSet.error();
        }
        return ResultSet.success();
    }
}
