package com.fzm.blogos.service.website;

import com.fzm.blogos.dto.blogger.BloggerBriefDTO;

import java.util.List;


public interface WebSiteStatisticsService {

    /**
     * 获取活跃博主
     *
     * @param count 获取博主格式
     * @return 集合
     */
    List<BloggerBriefDTO> listActiveBlogger(int count);

}
