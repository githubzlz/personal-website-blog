package com.zlz.website.blog.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlz.website.blog.common.dos.BlogContentDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogContentMapper extends BaseMapper<BlogContentDO> {
    int deleteById(Long id);

    int insertSelective(BlogContentDO record);

    BlogContentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogContentDO record);

    BlogContentDO selectLastVersionByBlogId(Long blogId);
}