package com.zlz.website.blog.tag.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlz.website.blog.common.dos.TagDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagMapper extends BaseMapper<TagDO> {

}