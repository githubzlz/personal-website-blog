package com.zlz.website.blog.blog.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlz.basic.response.PageInfo;
import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.dtos.BlogDTO;
import com.zlz.website.blog.common.req.blog.BlogListQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文章管理
 * @author zhulinzhong
 */
@Mapper
public interface BlogMapper extends BaseMapper<BlogDO> {

    List<BlogDO> selectListByParams(@Param("params") BlogListQueryParam params, @Param("pageInfo") PageInfo<BlogDTO> pageInfo);

    List<BlogDO> selectListByParamAll(@Param("params") BlogListQueryParam params, @Param("pageInfo") PageInfo<BlogDTO> pageInfo);
}