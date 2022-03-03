package com.zlz.website.blog.category.mapper;


import com.zlz.website.blog.common.dos.CategoryDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CategoryDO record);

    int insertSelective(CategoryDO record);

    CategoryDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CategoryDO record);

    int updateByPrimaryKey(CategoryDO record);
}