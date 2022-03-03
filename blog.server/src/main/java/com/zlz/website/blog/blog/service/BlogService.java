package com.zlz.website.blog.blog.service;

import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.common.vos.BlogVO;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:08:04
 */
public interface BlogService {

    /**
     * 创建文章
     * @param blog
     * @return
     */
    ResultSet<BlogVO> createBlog(BlogVO blog);
}
