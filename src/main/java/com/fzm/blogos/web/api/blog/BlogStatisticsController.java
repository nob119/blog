package com.fzm.blogos.web.api.blog;

import com.fzm.blogos.dto.blog.BlogStatisticsCountDTO;
import com.fzm.blogos.dto.blog.BlogStatisticsDTO;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.common.BlogStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/blog/{blogId}/statistics")
public class BlogStatisticsController extends BaseBlogController {

    @Autowired
    private BlogStatisticsService statisticsService;

    /**
     * 获得博文统计信息
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<BlogStatisticsDTO> get(HttpServletRequest request,
                                                        @PathVariable Integer blogId) {
        handleBlogStatisticsExistCheck(request, blogId);

        ResultBean<BlogStatisticsDTO> result = statisticsService.getBlogStatistics(blogId);
        if (result == null) handlerEmptyResult(request);

        return result;
    }

    /**
     * 获取统计信息（简版，只获取各项信息的次数）
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResultBean<BlogStatisticsCountDTO> getCount(HttpServletRequest request,
                                                                  @PathVariable Integer blogId) {
        handleBlogStatisticsExistCheck(request, blogId);

        ResultBean<BlogStatisticsCountDTO> statistics = statisticsService.getBlogStatisticsCount(blogId);
        if (statistics == null) handlerEmptyResult(request);

        return statistics;
    }

    // 检查博文的统计信息是否存在
    private void handleBlogStatisticsExistCheck(HttpServletRequest request, int blogId) {
        if (!blogValidateManager.checkBlogStatisticExist(blogId))
            throw exceptionManager.getUnknownBlogException(new RequestContext(request));
    }


}
