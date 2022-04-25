package com.zlz.website.blog.common.dtos;

import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-04-25 19:56:34
 */
@Data
public class TagDTO {

    private Long id;

    private Long parentId;

    private String name;

}
