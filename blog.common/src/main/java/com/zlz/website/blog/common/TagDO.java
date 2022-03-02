package com.zlz.website.blog.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 标签
 * @author zhulinzhong
 */
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
     * 0 不发布 1发布
     */
    private Byte isPublish;

    private Long creator;

    private Date createdTime;

    private Long lastModifier;

    private Date lastModifiedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Byte getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Byte isPublish) {
        this.isPublish = isPublish;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(Long lastModifier) {
        this.lastModifier = lastModifier;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    @Override
    public String toString() {
        return "TagDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", isPublish=" + isPublish +
                ", creator=" + creator +
                ", createdTime=" + createdTime +
                ", lastModifier=" + lastModifier +
                ", lastModifiedTime=" + lastModifiedTime +
                '}';
    }
}