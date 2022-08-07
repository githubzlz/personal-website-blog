package com.zlz.website.blog.common.dtos;

import lombok.Builder;
import lombok.Data;

/**
 * @author zhulinzhong
 * @date 2022-04-26 19:42:24
 */
@Data
@Builder
public class DatePairDTO {

    private Long startTime;

    private Long endTime;
}
