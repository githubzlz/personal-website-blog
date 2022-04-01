package com.zlz.website.blog.blog;

import com.zlz.route.common.trace.TraceContext;
import com.zlz.website.blog.common.dos.BlogContentDO;
import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.req.blog.BlogContentEditReq;
import com.zlz.website.blog.common.req.blog.BlogEditReq;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author zhulinzhong
 * @date 2022-03-07 19:54:48
 */
public class BlogBuilder {

    private BlogBuilder() {
    }

    public static BlogDO buildBlogDO(BlogEditReq req, Date date) {
        BlogDO blogDO = new BlogDO();
        BeanUtils.copyProperties(req, blogDO);
        blogDO.setUserId(TraceContext.getUserId());
        blogDO.setCreator(TraceContext.getUserId());
        blogDO.setOperator(TraceContext.getUserId());
        blogDO.setCreatedTime(date);
        blogDO.setModifiedTime(date);
        return blogDO;
    }

    public static BlogContentDO buildBlogContentDO(Long blogId, BlogContentEditReq req, Date date) {
        BlogContentDO blogContentDO = new BlogContentDO();
        BeanUtils.copyProperties(req, blogContentDO);
        blogContentDO.setBlogId(blogId);
        blogContentDO.setCreator(TraceContext.getUserId());
        blogContentDO.setOperator(TraceContext.getUserId());
        blogContentDO.setCreatedTime(date);
        blogContentDO.setModifiedTime(date);
        return blogContentDO;
    }

}
