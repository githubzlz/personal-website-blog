package com.zlz.website.blog.blog;

import com.zlz.website.blog.common.dos.BlogContentDO;
import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.dtos.BlogContentEditDTO;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author zhulinzhong
 * @date 2022-03-07 19:54:48
 */
public class BlogBuilder {

    public static BlogDO buildBlogDO(BlogEditReq req, Date date) {
        BlogDO blogDO = new BlogDO();
        BeanUtils.copyProperties(req, blogDO);
        return blogDO;
    }

    public static BlogContentDO buildBlogContentDO(Long blogId, BlogContentEditDTO req, Date date) {
        BlogContentDO blogContentDO = new BlogContentDO();
        BeanUtils.copyProperties(req, blogContentDO);
        blogContentDO.setBlogId(blogId);
        blogContentDO.setCreator(0L);
        blogContentDO.setOperator(0L);
        blogContentDO.setCreatedTime(date);
        blogContentDO.setModifiedTime(date);
        return blogContentDO;
    }

}
