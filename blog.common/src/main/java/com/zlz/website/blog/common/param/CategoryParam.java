package com.zlz.website.blog.common.param;

import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-03-30 17:00:43
 */
@Data
public class CategoryParam {

    private Long id;

    private String title;

    private Long creator;

    private Long parentId;

    private String levelCode;
}
