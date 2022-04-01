package com.zlz.website.blog.common.req.blog;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zhulinzhong
 * @date 2022-03-03 15:16:29
 */
@Data
public class BlogEditReq {

    /**
     * id
     */
    @NotNull(message = "文章id不允许为空", groups = Update.class)
    private Long id;

    /**
     * 文章名
     */
    @NotNull(message = "文章名称不允许为空", groups = Create.class)
    private String title;

    /**
     * 出处：0原创 1转载 2翻译
     */
    private Integer provenance;

    /**
     * 文章图片路径
     */
    private String imgSrc;

    /**
     * 0 发布 1不发布
     */
    private Integer isPublish = 0;

    /**
     * 文章内容
     */
    @NotNull(message = "文章内容不允许为空", groups = Create.class)
    private BlogContentEditReq blogContent;

    /**
     * 是否存在修改
     */
    @NotNull(message = "是否更新文章字段不允许为空", groups = Update.class)
    private Boolean update;

    public interface Create{}

    public interface Update{}
}
