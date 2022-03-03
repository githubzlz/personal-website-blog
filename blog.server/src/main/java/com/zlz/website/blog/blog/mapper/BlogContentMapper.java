package com.zlz.website.blog.blog.mapper;


import com.zlz.website.blog.common.dos.BlogContentDO;

public interface BlogContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlogContentDO record);

    int insertSelective(BlogContentDO record);

    BlogContentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogContentDO record);

    int updateByPrimaryKey(BlogContentDO record);
}