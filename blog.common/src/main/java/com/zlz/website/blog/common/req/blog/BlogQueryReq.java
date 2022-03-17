package com.zlz.website.blog.common.req.blog;

import com.zlz.basic.dto.DateRangeDTO;
import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-03-03 15:16:29
 */
@Data
public class BlogQueryReq {

    /**
     * 文章名
     */
    private String title;

    /**
     * 点赞数量
     */
    private Integer stars;

    /**
     * 阅读量
     */
    private Integer readings;

    /**
     * 出处：0原创 1转载 2翻译
     */
    private Integer provenance;

    /**
     * 0 发布 1不发布
     */
    private Integer isPublish;

    /**
     * 状态,0:未删除，1:已删除
     */
    private Integer isDeleted;

    /**
     * 数据创建时间
     */
    private DateRangeDTO createdTime;

    /**
     * 更新时间
     */
    private DateRangeDTO modifiedTime;

}
