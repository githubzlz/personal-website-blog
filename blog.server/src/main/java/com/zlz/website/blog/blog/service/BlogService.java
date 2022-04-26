package com.zlz.website.blog.blog.service;

import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.common.dtos.BlogDTO;
import com.zlz.website.blog.common.param.BlogParam;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import com.zlz.website.blog.common.req.blog.BlogListQueryReq;
import com.zlz.website.blog.common.resp.blog.BlogSimpleResp;

import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:08:04
 */
public interface BlogService {

    /**
     * 查询文章列表
     * @param req
     * @return
     */
    ResultSet<List<BlogDTO>> queryList(BlogListQueryReq req);

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
     * @param req 文章修改请求参数
     * @return base resp
     */
    ResultSet<Long> modifyBlog(BlogEditReq req);

    /**
     * 软（逻辑）删除文章
     *
     * @param blogId 文章id
     * @return base resp
     */
    ResultSet<Boolean> softDeleteBlog(Long blogId);

    /**
     * 完全删除文章
     *
     * @param blogId 文章id
     * @return base resp
     */
    ResultSet<Boolean> deleteBlog(Long blogId);

}
