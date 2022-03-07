package com.zlz.website.blog.common.dtos;

import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-03-07 19:35:47
 */
@Data
public class BlogContentEditDTO {

    /**
     * 文章id
     */
    private Long blogId;

    /**
     * 文章md信息
     */
    private String contentMd;

    /**
     * 编辑器类型：0:editormd
     */
    private Integer editorType;

    /**
     * 备注
     */
    private String note;


}
