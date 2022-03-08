package com.zlz.website.blog.blog.service.impl;

import com.zlz.basic.exception.BizException;
import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.blog.BlogBuilder;
import com.zlz.website.blog.blog.mapper.BlogContentMapper;
import com.zlz.website.blog.blog.mapper.BlogMapper;
import com.zlz.website.blog.blog.service.BlogService;
import com.zlz.website.blog.common.dos.BlogContentDO;
import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.dtos.BlogContentEditDTO;
import com.zlz.website.blog.common.exception.BlogBizException;
import com.zlz.website.blog.common.exception.BlogExceptionEnum;
import com.zlz.website.blog.common.param.BlogParam;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import com.zlz.website.blog.common.resp.blog.BlogSimpleResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
    public ResultSet<Long> createBlog(BlogEditReq req) {
        Date date = new Date();
        BlogDO blog = BlogBuilder.buildBlogDO(req, date);
        blogMapper.insert(blog);

        if (Objects.isNull(req.getBlogContent())) {
            throw new BlogBizException(BlogExceptionEnum.CREATE_BLOG_CONTENT_CANNOT_BE_NULL);
        }
        BlogContentDO blogContent = BlogBuilder.buildBlogContentDO(blog.getId(), req.getBlogContent(), date);
        blogContentMapper.insert(blogContent);
        return ResultSet.success(blog.getId());
    }

    @Override
    public ResultSet<Long> modifyBlog(BlogEditReq req) {
        Long blogId = req.getId();
        Date date = new Date();
        if(req.getUpdate()){
            BlogDO blog = BlogBuilder.buildBlogDO(req, date);
            blogMapper.updateByPrimaryKey(blog);
        }
        if (Objects.isNull(req.getBlogContent())) {
            throw new BlogBizException(BlogExceptionEnum.CREATE_BLOG_CONTENT_CANNOT_BE_NULL);
        }

        // 存在更新
        // 1.获取最后版本
        // 2.将最后版本置为无效
        // 3.插入新版本
        if (req.getBlogContent().getUpdate()) {
            BlogContentDO blogContent = BlogBuilder.buildBlogContentDO(blogId, req.getBlogContent(), date);
            BlogContentDO oldBlogContent = blogContentMapper.selectLastVersionByBlogId(blogId);
            blogContentMapper.deleteById(oldBlogContent.getId());

            blogContent.setVersion(oldBlogContent.getVersion()+1);
            blogContentMapper.insert(blogContent);

        }
        return ResultSet.success(blogId);
    }

    private boolean modifyBlogContent(BlogContentEditDTO dto) {
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
