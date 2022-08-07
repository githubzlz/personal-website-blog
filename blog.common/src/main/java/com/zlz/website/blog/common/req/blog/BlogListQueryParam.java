package com.zlz.website.blog.common.req.blog;

import com.zlz.website.blog.common.dtos.DatePairDTO;
import lombok.Data;

import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-04-26 19:30:21
 */
@Data
public class BlogListQueryParam {

    private String all;

    private String title;

    private Integer provenance;

    private List<Long> categories;

    private List<Long> tags;

    private DatePairDTO date;


    private Long creator;

    private Integer isDeleted;

}
