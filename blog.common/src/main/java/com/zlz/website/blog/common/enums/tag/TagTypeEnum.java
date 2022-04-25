package com.zlz.website.blog.common.enums.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhulinzhong
 * @date 2022-04-25 19:28:51
 */
@AllArgsConstructor
@Getter
public enum TagTypeEnum {


    TAG(0, "标签"),
    TAG_TYPE(1, "标签分类"),
    ;


    private Integer code;

    private String desc;
}
