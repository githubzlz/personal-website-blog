package com.zlz.website.blog.common.req.category;

import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-03-30 16:52:31
 */
@Data
public class CategoryQueryReq {

    private Long id;

    private String name;

    private String levelCode;

}
