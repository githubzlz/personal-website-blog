package com.zlz.website.blog.common.req.category;

import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-03-30 16:52:31
 */
@Data
public class CategoryUpdateReq {

    private Long id;

    private String name;

    private Long parentId;

    private String introduction;

    private String imageUrl;

    private Integer isPublish;

}
