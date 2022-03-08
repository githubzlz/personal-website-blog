package com.zlz.website.blog.blog.mapper;


import com.zlz.website.blog.common.dos.BlogContentDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogContentMapper {
    int deleteById(Long id);

    int insert(BlogContentDO record);

    int insertSelective(BlogContentDO record);

    BlogContentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogContentDO record);

    BlogContentDO selectLastVersionByBlogId(Long blogId);
}