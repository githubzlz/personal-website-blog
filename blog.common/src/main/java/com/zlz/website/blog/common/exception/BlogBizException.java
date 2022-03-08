package com.zlz.website.blog.common.exception;

import com.zlz.basic.exception.BizException;

/**
 * @author zhulinzhong
 * @date 2022-03-08 15:38:31
 */
public class BlogBizException extends BizException {

    public BlogBizException(BlogExceptionEnum message) {
        super(String.format("{code:'%s',message:'%s'}", message.getCode(), message.getMessage()));
    }
}
