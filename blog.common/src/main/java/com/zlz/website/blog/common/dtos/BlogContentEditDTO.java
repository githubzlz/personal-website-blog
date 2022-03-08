package com.zlz.website.blog.common.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zhulinzhong
 * @date 2022-03-07 19:35:47
 */
@Data
public class BlogContentEditDTO {

    /**
     * 是否存在文章内容修改
     */
    @NotNull(message = "是否更新文章内容字段不允许为空")
    private Boolean update;

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
