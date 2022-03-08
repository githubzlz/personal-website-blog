package com.zlz.website.blog.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlz.website.blog.common.dos.BlogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章管理
 * @author zhulinzhong
 */
@Mapper
public interface BlogMapper extends BaseMapper<BlogDO> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(BlogDO record);

    BlogDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogDO record);

    int updateByPrimaryKey(BlogDO record);
}