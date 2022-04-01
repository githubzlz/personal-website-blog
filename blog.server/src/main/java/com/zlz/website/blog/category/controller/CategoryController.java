package com.zlz.website.blog.category.controller;

import com.zlz.basic.response.ResultSet;
import com.zlz.basic.response.TreeNode;
import com.zlz.website.blog.category.service.CategoryService;
import com.zlz.website.blog.common.req.category.CategoryQueryReq;
import com.zlz.website.blog.common.dtos.CategoryDTO;
import com.zlz.website.blog.common.req.category.CategoryUpdateReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:50:14
 */
@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/update")
    public ResultSet<Long> updateCategory(@RequestBody CategoryUpdateReq req){
        return categoryService.updateCategory(req);
    }

    @PostMapping("/list")
    public ResultSet<List<CategoryDTO>> listCategory(@RequestBody CategoryQueryReq req){
        return categoryService.listCategory(req);
    }

    @PostMapping("/tree")
    public ResultSet<List<TreeNode<CategoryDTO>>> listCategoryTree(@RequestBody CategoryQueryReq req){
        return categoryService.listCategoryTree(req);
    }
}
