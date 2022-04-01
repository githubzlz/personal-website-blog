package com.zlz.website.blog.category.service;

import com.zlz.basic.response.ResultSet;
import com.zlz.basic.response.TreeNode;
import com.zlz.website.blog.common.dos.CategoryDO;
import com.zlz.website.blog.common.req.category.CategoryQueryReq;
import com.zlz.website.blog.common.dtos.CategoryDTO;
import com.zlz.website.blog.common.req.category.CategoryUpdateReq;

import java.util.List;

/**
 * @author wb_zhulinzhong
 * @date 2022-03-03 14:51:05
 */
public interface CategoryService {

    /**
     * 修改创建分类
     * @param req
     * @return
     */
    ResultSet<Long> updateCategory(CategoryUpdateReq req);

    /**
     * 查询用户所有分类
     * @param req
     * @return
     */
    ResultSet<List<CategoryDTO>> listCategory(CategoryQueryReq req);

    /**
     * 查询树状分类
     * @param req
     * @return
     */
    ResultSet<List<TreeNode<CategoryDTO>>> listCategoryTree(CategoryQueryReq req);
}
