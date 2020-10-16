package com.fzm.blogos.service.common;

import com.fzm.blogos.dto.blog.BlogStatisticsCountDTO;
import com.fzm.blogos.dto.blog.BlogStatisticsDTO;
import com.fzm.blogos.restful.ResultBean;


public interface BlogStatisticsService {

    /**
     * 获取博文统计信息
     *
     * @param blogId 博文id
     * @return 查询结果
     */
    ResultBean<BlogStatisticsDTO> getBlogStatistics(int blogId);

    /**
     * 获取博文统计信息（只获取数据量）
     *
     * @param blogId 博文id
     * @return 查询结果
     */
    ResultBean<BlogStatisticsCountDTO> getBlogStatisticsCount(int blogId);

    /**
     * 更新博文浏览次数（加一）
     *
     * @param blogId 博文id
     * @return 更新成功为true
     */
    boolean updateBlogViewCountPlus(int blogId);
}

