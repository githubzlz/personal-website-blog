package com.zlz.website.blog.common.enums.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhulinzhong
 * @date 2022-03-08 16:53:09
 */
@Getter
@AllArgsConstructor
public enum EditorTypeEnum {

    EDITOR_MD(1, "EditorMd");

    private Integer type;

    private String name;


}
