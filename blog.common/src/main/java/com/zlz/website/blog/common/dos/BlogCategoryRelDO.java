package com.zlz.website.blog.common.dos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("blog_category_relation")
public class BlogCategoryRelDO {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long blogId;

    private Long cateId;

    private Long creator;

    private Date createdTime;
}
