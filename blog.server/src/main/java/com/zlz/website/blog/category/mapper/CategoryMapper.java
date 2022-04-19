package com.zlz.website.blog.category.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlz.website.blog.common.dos.CategoryDO;
import com.zlz.website.blog.common.param.CategoryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<CategoryDO> {
    int deleteByPrimaryKey(Long id);

    int insertSelective(CategoryDO record);

    CategoryDO selectByPrimaryKey(@Param("id") Long id,
                                  @Param("userId") Long userId);

    int updateByPrimaryKeySelective(CategoryDO record);

    int updateByPrimaryKey(CategoryDO record);

    List<CategoryDO> selectListByParams(CategoryParam param);

    CategoryDO selectByParentId(@Param("parentId") Long parentId,
                                @Param("userId") Long userId);

    CategoryDO selectFirstLevel();
}