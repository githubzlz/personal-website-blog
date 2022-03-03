package com.zlz.website.blog.tag.controller;

import com.zlz.website.blog.common.dos.TagDO;
import com.zlz.website.blog.tag.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhulinzhong
 * @date 2022-03-02 11:44:49
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagMapper tagMapper;

    @GetMapping("/query-by-id")
    public TagDO getById(@RequestParam("id") Long id) {
        return null;
    }

    @GetMapping("/query-by-id-code")
    public TagDO getById(@RequestParam("id") Long id, @RequestParam("code") String code) {
        return null;
    }
}
