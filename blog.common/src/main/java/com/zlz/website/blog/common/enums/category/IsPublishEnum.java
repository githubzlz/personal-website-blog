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

    PUBLISHED(0, "发布"),
    DIS_PUBLISH(1, "不发布"),
    ;


    private Integer code;

    private String name;
}
