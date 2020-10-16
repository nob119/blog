package com.fzm.blogos.service.blogger;

import com.fzm.blogos.dto.blogger.BloggerDTO;
import com.fzm.blogos.dto.blogger.BloggerStatisticsDTO;
import com.fzm.blogos.restful.ResultBean;


public interface BloggerStatisticsService {

    /**
     * 获取博主统计信息
     *
     * @param bloggerId 博主id
     * @return 查询结果
     */
    ResultBean<BloggerStatisticsDTO> getBloggerStatistics(int bloggerId);

    /**
     * 根据 id 获取博主的 dto 对象
     * @param ids 博主 id
     * @return 数组
     */
    BloggerDTO[] listBloggerDTO(int... ids);

}
