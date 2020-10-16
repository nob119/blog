package com.fzm.blogos.service.impl.website;

import com.fzm.blogos.dto.blogger.BloggerBriefDTO;
import com.fzm.blogos.dto.blogger.BloggerDTO;
import com.fzm.blogos.dto.blogger.BloggerStatisticsDTO;
import com.fzm.blogos.manager.DataFillingManager;
import com.fzm.blogos.manager.WebsiteManager;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.blogger.BloggerStatisticsService;
import com.fzm.blogos.service.website.WebSiteStatisticsService;
import com.fzm.blogos.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class WebSiteStatisticsServiceImpl implements WebSiteStatisticsService {

    @Autowired
    private BloggerStatisticsService statisticsService;

    @Autowired
    private WebsiteManager websiteManager;

    @Autowired
    private DataFillingManager fillingManager;

    @Override
    public List<BloggerBriefDTO> listActiveBlogger(int count) {

        int[] ids = websiteManager.getActiveBloggerIds(count);
        BloggerDTO[] bloggerDTOS = statisticsService.listBloggerDTO(ids);
        if (CollectionUtils.isEmpty(bloggerDTOS)) return null;

        List<BloggerBriefDTO> dtos = new ArrayList<>();
        for (BloggerDTO blogger : bloggerDTOS) {
            ResultBean<BloggerStatisticsDTO> statistics = statisticsService.getBloggerStatistics(blogger.getId());
            final BloggerBriefDTO dto = fillingManager.bloggerTobrief(blogger, statistics.getData());
            dtos.add(dto);
        }

        return dtos;
    }

}
