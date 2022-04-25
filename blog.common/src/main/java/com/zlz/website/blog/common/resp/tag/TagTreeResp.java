package com.zlz.website.blog.common.resp.tag;

import com.zlz.website.blog.common.dtos.TagDTO;
import lombok.Data;

import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-04-25 19:56:02
 */
@Data
public class TagTreeResp {

    private Long id;

    private String name;

    private List<TagDTO> tags;
}
