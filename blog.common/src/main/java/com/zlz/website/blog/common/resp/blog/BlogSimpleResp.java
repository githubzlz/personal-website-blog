package com.zlz.website.blog.common.resp.blog;

import lombok.Data;

import java.util.Date;

/**
 * @author zhulinzhong
 * @date 2022-03-03 15:20:37
 */
@Data
public class BlogSimpleResp {

    /**
     * id
     */
    private Long id;

    /**
     * 作者id
     */
    private String author;

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
     * 点赞数量
     */
    private Integer stars;

    /**
     * 阅读量
     */
    private Integer readings;

    /**
     * 0 发布 1不发布
     */
    private Integer isPublish;

    /**
     * 状态,0:未删除，1:已删除
     */
    private Integer isDeleted;

    /**
     * 更新时间
     */
    private Date modifiedTime;
}
