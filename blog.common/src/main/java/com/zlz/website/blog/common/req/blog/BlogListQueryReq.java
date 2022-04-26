package com.zlz.website.blog.common.req.blog;

import com.zlz.basic.response.PageInfo;
import com.zlz.website.blog.common.dtos.BlogDTO;
import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-03-03 15:16:29
 */
@Data
public class BlogListQueryReq {

    private PageInfo<BlogDTO> pageInfo;

    private BlogListQueryParam params;

}
