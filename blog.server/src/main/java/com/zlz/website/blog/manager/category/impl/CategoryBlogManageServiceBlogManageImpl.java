package com.zlz.website.blog.manager.category.impl;

import com.zlz.website.blog.blog.service.BlogService;
import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.dos.TagDO;
import com.zlz.website.blog.manager.category.CategoryBlogManageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-03-03 15:34:53
 */
@Service
public class CategoryBlogManageServiceBlogManageImpl implements CategoryBlogManageService {

    private final BlogService blogService;

    private final CategoryBlogManageService categoryBlogManageService;

    public CategoryBlogManageServiceBlogManageImpl(BlogService blogService, CategoryBlogManageService categoryBlogManageService) {
        this.blogService = blogService;
        this.categoryBlogManageService = categoryBlogManageService;
    }


    @Override
    public List<TagDO> getTagsByBlogIds(List<Long> blogIds) {
        return null;
    }

    @Override
    public List<BlogDO> getBlogByTagIds(List<Long> tagIds) {
        return null;
    }
}
