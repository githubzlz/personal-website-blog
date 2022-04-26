package com.zlz.website.blog.tag.service;

import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.common.dtos.TagDTO;
import com.zlz.website.blog.common.req.tag.TagEditReq;
import com.zlz.website.blog.common.req.tag.TagQueryReq;
import com.zlz.website.blog.common.resp.tag.TagTreeResp;

import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:08:23
 */
public interface TagService {

    /**
     * 根据名称查询标签
     * @param name
     * @return
     */
    ResultSet<List<TagDTO>> queryListByName(TagQueryReq req);

    /**
     * 查询标签
     * @return
     */
    ResultSet<List<TagTreeResp>> queryTagTree();

    /**
     * 创建标签分类
     * @param req
     * @return
     */
    ResultSet<Long> createTagCate(TagEditReq req);

    /**
     * 创建标签
     * @param req
     * @return
     */
    ResultSet<Long> createTag(TagEditReq req);

    /**
     * 逻辑删除
     * @return
     * @param req
     */
    ResultSet<Long> softDeleteTag(TagEditReq req);

}
