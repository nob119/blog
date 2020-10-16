package com.fzm.blogos.manager.properties;

import lombok.Data;


@Data
public class AudienceProperties {

    /**
     * 默认返回的博主博文列表数量
     */
    private Integer requestBloggerBlogListCount;

    /**
     * 默认返回的博主博文评论数量
     */
    private Integer requestBloggerBlogCommentCount;

}
