package com.zlz.website.blog.common.enums.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wb_zhulinzhong
 * @date 2021-06-08 18:07:47
 */
@Getter
@AllArgsConstructor
public enum IsPublishEnum {

    DISPUBLISH(0, "不发布"),
    PUBLISHED(1, "发布"),
    ;


    private Integer code;

    private String name;
}
