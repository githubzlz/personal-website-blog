package com.zlz.website.blog.common.dos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签
 *
 * @author zhulinzhong
 */
@Data
public class TagDO implements Serializable {

    private Long id;

    /**
     * 标签名
     */
    private String name;

    /**
     * 预留字段，暂不使用
     */
    private String code;

    /**
     * 0 展示 1 隐藏
     */
    private Integer isShow;

    private Long creator;

    private Date createdTime;

    private Long lastModifier;

    private Date lastModifiedTime;

}