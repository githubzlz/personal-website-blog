package com.zlz.website.blog.common.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * category
 *
 * @author
 */
@Data
@TableName("category")
public class CategoryDO implements Serializable {
    /**
     * 模块id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 分类等级
     */
    private Integer level;

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
     * 0 发布 1不发布
     */
    private Integer isPublish;

    /**
     * 0 未删除 1 删除
     */
    private Integer isDeleted;

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