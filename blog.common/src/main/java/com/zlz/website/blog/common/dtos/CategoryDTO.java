package com.zlz.website.blog.common.dtos;

import lombok.Data;

import java.util.Date;

/**
 * @author zhulinzhong
 * @date 2022-03-30 16:53:03
 */
@Data
public class CategoryDTO {

    private Long id;

    private String name;

    private Integer level;

    private String levelCode;

    private Date createdTime;

    private Date lastModifiedTime;

}
