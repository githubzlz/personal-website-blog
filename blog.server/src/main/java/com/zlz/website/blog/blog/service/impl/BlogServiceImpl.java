package com.zlz.website.blog.blog.service.impl;

import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.blog.mapper.BlogContentMapper;
import com.zlz.website.blog.blog.mapper.BlogMapper;
import com.zlz.website.blog.blog.service.BlogService;
import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.param.BlogParam;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import com.zlz.website.blog.common.resp.blog.BlogSimpleResp;
import org.springframework.stereotype.Service;

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
    public ResultSet<Long> createBlog(BlogEditReq req) {
        return null;
    }

    @Override
    public ResultSet<Long> modifyBlogSimpInfo(BlogEditReq blog) {
        return null;
    }

    @Override
    public ResultSet<Long> modifyBlogContent(BlogEditReq blog) {
        return null;
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
