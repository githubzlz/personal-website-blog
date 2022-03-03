package com.zlz.website.blog.common.dos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * blog
 * @author 
 */
@Data
public class BlogDO implements Serializable {
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
    private Byte provenance;

    /**
     * 文章名
     */
    private Byte visibleStrategy;

    /**
     * 文章图片路径
     */
    private String imgSrc;

    /**
     * 0 不允许 1 允许
     */
    private Byte isShow;

    /**
     * 点赞数量
     */
    private Integer stars;

    /**
     * 阅读量
     */
    private Integer readings;

    /**
     * 状态,0:未删除，1:已删除
     */
    private Byte isDeleted;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 操作人
     */
    private Long operator;

    /**
     * 数据创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;
}