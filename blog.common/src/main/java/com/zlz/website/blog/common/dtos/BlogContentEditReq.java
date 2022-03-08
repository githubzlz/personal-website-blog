package com.zlz.website.blog.common.dtos;

import com.zlz.website.blog.common.req.blog.BlogEditReq;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zhulinzhong
 * @date 2022-03-07 19:35:47
 */
@Data
public class BlogContentEditReq {

    /**
     * 是否存在文章内容修改
     */
    @NotNull(message = "是否更新文章内容字段不允许为空", groups = BlogEditReq.Update.class)
    private Boolean update;

    /**
     * 文章id
     */
    private Long blogId;

    /**
     * 文章内容
     */
    @NotNull(message = "文章内容不允许为空", groups = BlogEditReq.Create.class)
    private String content;

    /**
     * 编辑器类型：0:editormd
     */
    @NotNull(message = "编辑器类型不允许为空", groups = BlogEditReq.Create.class)
    private Integer editorType;

    /**
     * 备注
     */
    private String note;


}
