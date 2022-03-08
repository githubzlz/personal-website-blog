package com.zlz.website.blog.blog.service.impl;

import com.zlz.basic.response.ResultSet;
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

    private boolean modifyBlogContent(BlogContentEditReq dto) {
        return false;
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
    public ResultSet<List<BlogDO>> batchQueryBlogContent(BlogParam params) {
        return null;
    }

    @Override
    public ResultSet<Boolean> softDeleteBlog(Long blogId) {
        return null;
    }

    @Override
    public ResultSet<Boolean> batchSoftDeleteBlog(List<Long> blogIds) {
        return null;
    }

    @Override
    public ResultSet<Boolean> deleteBlog(Long blogId) {
        return null;
    }

    @Override
    public ResultSet<Boolean> batchDeleteBlog(List<Long> blogIds) {
        return null;
    }
}
