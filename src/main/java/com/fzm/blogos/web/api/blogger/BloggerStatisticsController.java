package com.fzm.blogos.web.api.blogger;

import com.fzm.blogos.dto.blogger.BloggerStatisticsDTO;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.blogger.BloggerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/blogger/{bloggerId}/statistic")
public class BloggerStatisticsController extends BaseBloggerController {

    @Autowired
    private BloggerStatisticsService statisticsService;

    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<BloggerStatisticsDTO> get(HttpServletRequest request,
                                                @PathVariable Integer bloggerId) {

        handleAccountCheck(request, bloggerId);

        ResultBean<BloggerStatisticsDTO> statistics = statisticsService.getBloggerStatistics(bloggerId);
        if (statistics == null) handlerOperateFail(request);

        return statistics;
    }

}
