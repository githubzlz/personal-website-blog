package com.zlz.website.blog.common.req.blog;

import com.zlz.website.blog.common.dtos.BlogContentEditDTO;
import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-03-03 15:16:29
 */
@Data
public class BlogEditReq {

    /**
     * id
     */
    private Long id;

    /**
     * 作者id
     */
    private Long userId;

    /**
     * 文章名
     */
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
    private BlogContentEditDTO blogContent;
}
