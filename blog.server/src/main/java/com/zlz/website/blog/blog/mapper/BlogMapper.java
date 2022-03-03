package com.zlz.website.blog.blog.mapper;


import com.zlz.website.blog.common.dos.BlogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章管理
 * @author zhulinzhong
 */
@Mapper
public interface BlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlogDO record);

    int insertSelective(BlogDO record);

    BlogDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogDO record);

    int updateByPrimaryKey(BlogDO record);
}