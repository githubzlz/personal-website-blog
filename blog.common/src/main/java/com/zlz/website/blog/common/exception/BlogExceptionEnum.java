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

    MODIFY_BLOG_ERROR(1000001, "文章修改失败"),
    DELETE_BLOG_ERROR(1000002, "存在子分类，无法删除"),
    ;

    private Integer code;

    private String message;
}
