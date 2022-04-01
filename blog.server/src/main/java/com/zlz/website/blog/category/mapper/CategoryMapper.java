package com.zlz.website.blog.category.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlz.website.blog.common.dos.CategoryDO;
import com.zlz.website.blog.common.param.CategoryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper{
    int deleteByPrimaryKey(Long id);

    int insert(CategoryDO record);

    int insertSelective(CategoryDO record);

    CategoryDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CategoryDO record);

    int updateByPrimaryKey(CategoryDO record);

    List<CategoryDO> selectList(CategoryParam param);

    CategoryDO selectByParentId(Long parentId);

    CategoryDO selectFirstLevel();
}