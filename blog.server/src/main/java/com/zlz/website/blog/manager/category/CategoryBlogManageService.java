package com.zlz.website.blog.manager.category;

import com.zlz.website.blog.common.dos.BlogDO;
import com.zlz.website.blog.common.dos.TagDO;

import java.util.List;

/**
 * @author zhulinzhong
 * @date 2022-03-03 15:33:16
 */
public interface CategoryBlogManageService {

    /**
     * 根据文章id获取下属标签信息
     *
     * @param blogIds
     * @return
     */
    List<TagDO> getTagsByBlogIds(List<Long> blogIds);

    /**
     * 根据标签id获取下属文章信息
     *
     * @param tagIds
     * @return
     */
    List<BlogDO> getBlogByTagIds(List<Long> tagIds);


}
