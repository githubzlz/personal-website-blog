package com.zlz.website.blog.common.transfer;

import com.zlz.basic.trace.TraceContext;
import com.zlz.website.blog.common.dos.TagDO;
import com.zlz.website.blog.common.dtos.TagDTO;
import com.zlz.website.blog.common.enums.blog.BlogShowEnum;
import com.zlz.website.blog.common.req.tag.TagEditReq;
import com.zlz.website.blog.common.resp.tag.TagTreeResp;

import java.util.Date;

/**
 * @author zhulinzhong
 * @date 2022-04-25 19:40:29
 */
public class TagTransfer {

    public static TagDO buildTagDO(TagEditReq req) {
        TagDO tag = new TagDO();
        tag.setParentId(req.getParentId());
        tag.setAliasName(req.getAliasName());
        tag.setName(req.getName());
        tag.setIsShow(BlogShowEnum.SHOW.getCode());
        tag.setCreator(TraceContext.getUserId());
        tag.setLastModifier(TraceContext.getUserId());
        Date now = new Date();
        tag.setCreatedTime(now);
        tag.setLastModifiedTime(now);
        return tag;
    }

    public static TagDTO trans2TagDTO(TagDO tagDO) {
        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tagDO.getId());
        tagDTO.setParentId(tagDTO.getParentId());
        tagDTO.setName(tagDO.getName());
        return tagDTO;
    }

    public static TagTreeResp trans2TagTreeResp(TagDO tagDO) {
        TagTreeResp resp = new TagTreeResp();
        resp.setId(tagDO.getId());
        resp.setName(tagDO.getName());
        return resp;
    }
}
