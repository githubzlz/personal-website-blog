package com.zlz.website.blog.blog.controller;

import com.zlz.basic.constants.BasicConstants;
import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.blog.service.BlogService;
import com.zlz.website.blog.common.dtos.BlogDTO;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import com.zlz.website.blog.common.req.blog.BlogListQueryReq;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/edit")
    public ResultSet<Long> modifyBlog(@RequestBody @Validated BlogEditReq req) {

        // 新增
        if (Objects.isNull(req.getId()) || BasicConstants.ZERO_LONG.equals(req.getId())) {
            return blogService.createBlog(req);
        }

        // 编辑
        return blogService.modifyBlog(req);
    }

    @PostMapping("/update/publish")
    public ResultSet<Long> updatePublish(@RequestBody BlogEditReq req) {
        // 新增
        if (Objects.isNull(req.getId()) || BasicConstants.ZERO_LONG.equals(req.getId())) {
            return ResultSet.error("修改发布状态失败");
        }
        return blogService.updatePublish(req);
    }

    @PostMapping("/query/list")
    public ResultSet<List<BlogDTO>> queryList(@RequestBody BlogListQueryReq req) {
        return blogService.queryList(req);
    }

    @GetMapping("/delete/soft/{id}")
    public ResultSet<Boolean> deleteBlog(@PathVariable Long id) {
        // 删除
        return blogService.softDeleteBlog(id);
    }
}
