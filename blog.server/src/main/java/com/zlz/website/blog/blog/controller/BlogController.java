package com.zlz.website.blog.blog.controller;

import com.zlz.basic.constants.BasicConstants;
import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.blog.service.BlogService;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:07:01
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("edit")
    public ResultSet<Long> modifyBlog(@RequestBody BlogEditReq req) {
        // 新增
        if (Objects.isNull(req.getId()) || BasicConstants.ZERO_LONG.equals(req.getId())) {
            return blogService.createBlog(req);
        }

        // 编辑
        return blogService.modifyBlog(req);
    }
}
