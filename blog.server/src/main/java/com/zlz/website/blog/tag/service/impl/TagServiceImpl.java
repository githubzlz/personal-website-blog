package com.zlz.website.blog.tag.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zlz.basic.enums.DeletedStatusEnum;
import com.zlz.basic.response.ResultSet;
import com.zlz.basic.trace.TraceContext;
import com.zlz.website.blog.common.dos.TagDO;
import com.zlz.website.blog.common.dtos.TagDTO;
import com.zlz.website.blog.common.enums.tag.TagTypeEnum;
import com.zlz.website.blog.common.req.tag.TagEditReq;
import com.zlz.website.blog.common.resp.tag.TagTreeResp;
import com.zlz.website.blog.common.transfer.TagTransfer;
import com.zlz.website.blog.tag.mapper.TagMapper;
import com.zlz.website.blog.tag.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author zhulinzhong
 * @date 2022-03-03 14:08:58
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper  tagMapper;

    @Override
    public ResultSet<Long> createTagCate(TagEditReq req) {
        TagDO tag = TagTransfer.buildTagDO(req);
        tag.setTagType(TagTypeEnum.TAG_TYPE.getCode());
        tagMapper.insert(tag);
        return ResultSet.success(tag.getId());
    }

    @Override
    public ResultSet<Long> createTag(TagEditReq req) {
        TagDO tag = TagTransfer.buildTagDO(req);
        tag.setTagType(TagTypeEnum.TAG.getCode());
        tagMapper.insert(tag);
        return ResultSet.success(tag.getId());
    }


    @Override
    public ResultSet<List<TagTreeResp>> queryTagTree() {
        QueryWrapper<TagDO> wrapper = new QueryWrapper<>();
        wrapper.eq("is_deleted", DeletedStatusEnum.NOT_DELETED);
        wrapper.eq("creator", TraceContext.getUserId());
        List<TagDO> tags = tagMapper.selectList(wrapper);
        List<TagTreeResp> respList = new ArrayList<>();
        Map<Long, List<TagDTO>> tagMap = new HashMap<>();
        for (TagDO tag : tags) {
            if(TagTypeEnum.TAG_TYPE.getCode().equals(tag.getTagType())){
                respList.add(TagTransfer.trans2TagTreeResp(tag));
                continue;
            }
            List<TagDTO> tagDTOList = tagMap.computeIfAbsent(tag.getParentId(), v -> new ArrayList<>());
            tagDTOList.add(TagTransfer.trans2TagDTO(tag));
        }

        for (TagTreeResp resp : respList) {
            resp.setTags(tagMap.get(resp.getId()));
        }
        return ResultSet.success(respList);
    }

    @Override
    public ResultSet<Long> softDeleteTag(TagEditReq req) {
        TagDO update = new TagDO() ;
        update.setId(req.getId());
        update.setIsDeleted(DeletedStatusEnum.DELETED.getCode());
        tagMapper.updateById(update);
        return ResultSet.success(update.getId());
    }
}
