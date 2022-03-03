package com.zlz.website.blog.common.dos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * category
 * @author
 */
@Data
public class CategoryDO implements Serializable {
    /**
     * 模块id
     */
    private Long id;

    /**
     * 分类等级
     */
    private Byte level;

    private String levelCode;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 模块标题
     */
    private String title;

    /**
     * 模块介绍
     */
    private String introduction;

    /**
     * 模块图片路径
     */
    private String imageUrl;

    /**
     * 0 不发布 1发布
     */
    private Boolean isPublish;

    /**
     * 0 未删除 1 删除
     */
    private Boolean isDeleted;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 最后修改人
     */
    private Long lastModifier;

    /**
     * 最后修改时间
     */
    private Date lastModifiedTime;

    private static final long serialVersionUID = 1L;
}