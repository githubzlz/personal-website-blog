package com.zlz.website.blog.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zlz.basic.constants.BasicConstants;
import com.zlz.basic.enums.DeletedStatusEnum;
import com.zlz.basic.response.ResultSet;
import com.zlz.route.common.trace.TraceContext;
import com.zlz.website.blog.blog.BlogBuilder;
import com.zlz.website.blog.blog.mapper.BlogContentMapper;
import com.zlz.website.blog.blog.mapper.BlogMapper;
import com.zlz.website.blog.blog.service.BlogService;
import com.zlz.website.blog.common.dos.BlogContentDO;
import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.dtos.BlogContentEditReq;
import com.zlz.website.blog.common.enums.blog.EditorTypeEnum;
import com.zlz.website.blog.common.exception.BlogBizException;
import com.zlz.website.blog.common.exception.BlogExceptionEnum;
import com.zlz.website.blog.common.param.BlogParam;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import com.zlz.website.blog.common.resp.blog.BlogSimpleResp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:09:24
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;
    private final BlogContentMapper blogContentMapper;

    public BlogServiceImpl(BlogMapper blogMapper, BlogContentMapper blogContentMapper) {
        this.blogMapper = blogMapper;
        this.blogContentMapper = blogContentMapper;
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
        return ResultSet.success(blog.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultSet<Long> modifyBlog(BlogEditReq req) {
        Long blogId = req.getId();
        Date date = new Date();
        if (req.getUpdate()) {
            BlogDO blog = BlogBuilder.buildBlogDO(req, date);
            blogMapper.updateByPrimaryKey(blog);
        }

        // 存在更新
        // 1.获取最后版本
        // 2.将最后版本置为无效
        // 3.插入新版本
        if (req.getBlogContent().getUpdate()) {
            BlogContentDO blogContent = BlogBuilder.buildBlogContentDO(blogId, req.getBlogContent(), date);
            BlogContentDO oldBlogContent = blogContentMapper.selectLastVersionByBlogId(blogId);
            blogContentMapper.deleteById(oldBlogContent.getId());

            blogContent.setVersion(oldBlogContent.getVersion() + 1);
            blogContentMapper.insert(blogContent);

        }

        if (!req.getUpdate() && !req.getBlogContent().getUpdate()) {
            throw new BlogBizException(BlogExceptionEnum.MODIFY_BLOG_ERROR);
        }
        return ResultSet.success(blogId);
    }

    @Override
    public ResultSet<BlogSimpleResp> queryBlogSimpleInfo(Long blogId) {
        return null;
    }

    @Override
    public ResultSet<BlogSimpleResp> queryBlogContent(Long blogId) {
        return null;
    }

    @Override
    public ResultSet<List<BlogSimpleResp>> batchQueryBlog(BlogParam params) {
        return null;
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
    public ResultSet<Boolean> batchSoftDeleteBlog(List<Long> blogIds) {
        return null;
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
    public ResultSet<Boolean> batchDeleteBlog(List<Long> blogIds) {
        return null;
    }
}
