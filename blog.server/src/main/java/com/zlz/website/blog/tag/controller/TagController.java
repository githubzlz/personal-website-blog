package com.zlz.website.blog.tag.controller;

import com.zlz.basic.response.ResultSet;
import com.zlz.website.blog.common.dos.TagDO;
import com.zlz.website.blog.common.dtos.TagDTO;
import com.zlz.website.blog.common.req.tag.TagEditReq;
import com.zlz.website.blog.common.req.tag.TagQueryReq;
import com.zlz.website.blog.common.resp.tag.TagTreeResp;
import com.zlz.website.blog.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-03-02 11:44:49
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping("/query-by-name")
    public ResultSet<List<TagDTO>> queryListByName(@RequestBody TagQueryReq req) {
        return tagService.queryListByName(req);
    }

    @GetMapping("/query-by-id-code")
    public TagDO getById(@RequestParam("id") Long id, @RequestParam("code") String code) {
        return null;
    }

    @GetMapping("/tree")
    public ResultSet<List<TagTreeResp>> queryTagTree() {
        return tagService.queryTagTree();
    }

    @PostMapping("/create/cate")
    public ResultSet<Long> createTagCate(@RequestBody TagEditReq req) {
        return tagService.createTagCate(req);
    }

    @PostMapping("/create")
    public ResultSet<Long> createTag(@RequestBody TagEditReq req) {
        return tagService.createTag(req);
    }

    @PostMapping("/delete")
    public ResultSet<Long> deleteTag(@RequestBody TagEditReq req) {
        return tagService.softDeleteTag(req);
    }

}
