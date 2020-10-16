package com.fzm.blogos.web.blog;

import com.fzm.blogos.dto.blogger.BloggerStatisticsDTO;
import com.fzm.blogos.entity.blogger.BloggerAccount;
import com.fzm.blogos.manager.BloggerSessionManager;
import com.fzm.blogos.manager.properties.BloggerProperties;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.blogger.BloggerAccountService;
import com.fzm.blogos.service.blogger.BloggerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/{pageOwnerBloggerName}/blog/favourite")
public class FavouriteBlogPageController {

    @Autowired
    private BloggerAccountService accountService;

    @Autowired
    private BloggerSessionManager sessionManager;

    @Autowired
    private BloggerProperties bloggerProperties;

    @Autowired
    private BloggerStatisticsService statisticsService;

    @RequestMapping("/like")
    public ModelAndView pageLike(HttpServletRequest request,
                                 @ModelAttribute
                                 @PathVariable String pageOwnerBloggerName) {
        ModelAndView mv = new ModelAndView();
        setCommon(mv, request, pageOwnerBloggerName);

        mv.addObject("type", "like");
        return mv;
    }

    @RequestMapping("/collect")
    public ModelAndView pageCollect(HttpServletRequest request,
                                    @ModelAttribute
                                    @PathVariable String pageOwnerBloggerName) {
        ModelAndView mv = new ModelAndView();
        setCommon(mv, request, pageOwnerBloggerName);

        mv.addObject("type", "collect");
        return mv;
    }

    private void setCommon(ModelAndView mv, HttpServletRequest request, String bloggerName) {
        mv.setViewName("/blogger/favourite_blog");

        // 登陆博主 id
        int loginBloggerId = sessionManager.getLoginBloggerId(request);
        ResultBean<BloggerStatisticsDTO> loginBgStat = statisticsService.getBloggerStatistics(loginBloggerId);
        mv.addObject("loginBgStat", loginBgStat.getData());

        BloggerAccount account = accountService.getAccount(bloggerName);
        mv.addObject(bloggerProperties.getNameOfPageOwnerBloggerId(), account.getId());
        mv.addObject(bloggerProperties.getNameOfPageOwnerBloggerName(), account.getUsername());

    }

}
