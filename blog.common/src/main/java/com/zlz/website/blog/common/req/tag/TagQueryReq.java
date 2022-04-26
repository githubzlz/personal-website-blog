package com.zlz.website.blog.common.req.tag;

import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-04-25 19:19:45
 */
@Data
public class TagQueryReq {

    private Long id;

    private Long parentId;

    private String name;

    private String aliasName;

}
