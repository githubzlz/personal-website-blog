package com.zlz.website.blog.tag.mapper;

import com.zlz.website.blog.common.dos.TagDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TagDO record);

    int insertSelective(TagDO record);

    TagDO selectByPrimaryKey(Long id);

    TagDO selectByIdAndCode(@Param("id") Long id,@Param("testCode")  String testCode);

    int updateByPrimaryKeySelective(TagDO record);

    int updateByPrimaryKey(TagDO record);
}