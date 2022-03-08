package com.zlz.website.blog.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wb_zhulinzhong
 * @date 2022-03-08 15:36:19
 */
@Getter
@AllArgsConstructor
public enum BlogExceptionEnum {

    CREATE_BLOG_CONTENT_CANNOT_BE_NULL(1000001, "文章内容不允许为空")

    ;

    private Integer code;

    private String message;
}
