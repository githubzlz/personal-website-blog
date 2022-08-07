package com.zlz.website.blog.category.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlz.website.blog.common.dos.BlogCategoryRelDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryRelMapper extends BaseMapper<BlogCategoryRelDO> {
    /**
     * 批量插入
     * @param rels
     */
    void insertList(List<BlogCategoryRelDO> rels);
}
