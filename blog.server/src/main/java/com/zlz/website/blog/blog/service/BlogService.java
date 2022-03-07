package com.zlz.website.blog.blog.service;

import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.param.BlogParam;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import com.zlz.website.blog.common.resp.blog.BlogSimpleResp;

import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:08:04
 */
public interface BlogService {

    /**
     * 创建文章
     *
     * @param req 文章创建请求参数
     * @return base resp
     */
    ResultSet<Long> createBlog(BlogEditReq req);

    /**
     * 修改文章信息
     *
     * @param blog 文章修改请求参数
     * @return base resp
     */
    ResultSet<Long> modifyBlogSimpInfo(BlogEditReq blog);

    /**
     * 修改文章内容
     *
     * @param blog 文章修改请求参数
     * @return base resp
     */
    ResultSet<Long> modifyBlogContent(BlogEditReq blog);

    /**
     * 查询文章信息
     *
     * @param blogId 文章id
     * @return base resp
     */
    ResultSet<BlogSimpleResp> queryBlogSimpleInfo(Long blogId);

    /**
     * 查询文章内容
     *
     * @param blogId 文章id
     * @return base resp
     */
    ResultSet<BlogSimpleResp> queryBlogContent(Long blogId);

    /**
     * 查询文章信息：批量
     *
     * @param params 文章查询参数
     * @return base resp
     */
    ResultSet<List<BlogDO>> batchQueryBlogContent(BlogParam params);

    /**
     * 软（逻辑）删除文章
     *
     * @param blogId 文章id
     * @return base resp
     */
    ResultSet<Boolean> softDeleteBlog(Long blogId);

    /**
     * 软（逻辑）删除文章：批量
     *
     * @param blogIds 文章id集合
     * @return base resp
     */
    ResultSet<Boolean> batchSoftDeleteBlog(List<Long> blogIds);

    /**
     * 完全删除文章
     *
     * @param blogId 文章id
     * @return base resp
     */
    ResultSet<Boolean> deleteBlog(Long blogId);

    /**
     * 完全删除文章：批量
     *
     * @param blogIds 文章id集合
     * @return base resp
     */
    ResultSet<Boolean> batchDeleteBlog(List<Long> blogIds);
}
