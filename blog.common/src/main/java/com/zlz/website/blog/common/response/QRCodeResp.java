package com.zlz.website.blog.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录二维码消息
 *
 * @author wb_zhulinzhong
 * @date 2021-06-04 15:55:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QRCodeResp {

    private String token;

    private String encode;
}
