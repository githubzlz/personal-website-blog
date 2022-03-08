package com.zlz.website.blog.common.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * blog_content
 *
 * @author
 */
@Data
@TableName("blog_content")
public class BlogContentDO implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.ID_WORKER)
    private Long id;

    /**
     * 文章
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
     * 文章名
     */
    private String note;

    /**
     * 版本
     */
    private Integer version;

    /**
     * 状态：0:生效 1:失效
     */
    private Integer state;

    /**
     * 状态,0:未删除，1:已删除
     */
    private Integer isDeleted;

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

}