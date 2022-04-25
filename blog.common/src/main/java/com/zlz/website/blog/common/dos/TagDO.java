package com.zlz.website.blog.common.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签
 *
 * @author zhulinzhong
 */
@Data
@TableName("tag")
public class TagDO implements Serializable {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 标签名
     */
    private String name;

    /**
     * 别名
     */
    private String aliasName;

    /**
     * 0 展示 1 隐藏
     */
    private Integer isShow;

    /**
     * 标签类型：0：标签 1：标签分类
     */
    private Integer tagType;

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

    /**
     * 0 未删除 1 删除
     */
    private Integer isDeleted;
}