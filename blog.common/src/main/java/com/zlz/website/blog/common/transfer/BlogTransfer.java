package com.zlz.website.blog.common.transfer;

import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.dtos.BlogDTO;
import org.springframework.beans.BeanUtils;

public class BlogTransfer {

    public static BlogDTO trans2BlogDTO(BlogDO blogDO) {
        BlogDTO dto = new BlogDTO();
        BeanUtils.copyProperties(blogDO, dto);
        return dto;
    }
}
