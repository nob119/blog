package com.fzm.blogos.web.blog;

import com.fzm.blogos.dto.blogger.BloggerStatisticsDTO;
import com.fzm.blogos.entity.blog.Blog;
import com.fzm.blogos.enums.BlogStatusEnum;
import com.fzm.blogos.manager.validate.BloggerValidateManager;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.blogger.BloggerBlogService;
import com.fzm.blogos.service.blogger.BloggerStatisticsService;
import com.fzm.blogos.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/edit_blog")
public class EditBlogPageController {

    @Autowired
    private BloggerValidateManager bloggerValidateManager;

    @Autowired
    private BloggerBlogService blogService;

    @Autowired
    private BloggerStatisticsService statisticsService;

    @RequestMapping
    public ModelAndView mainPage(HttpServletRequest request,
                                 @RequestParam(value = "bid", required = false) Integer bloggerId,
                                 @RequestParam(value = "blogId", required = false) Integer blogId) {
        ModelAndView mv = new ModelAndView();

        if (bloggerId == null || !bloggerValidateManager.checkBloggerSignIn(request, bloggerId)) {
            return new ModelAndView("redirect:/login");
        } else {
            if (blogId != null) {
                ResultBean<Blog> blog = blogService.getBlog(bloggerId, blogId);
                Blog data = blog.getData();
                mv.addObject("blogId", blogId);
                mv.addObject("categoryId", data.getCategoryIds());
                mv.addObject("labelIds", data.getLabelIds());
                mv.addObject("blogTitle", data.getTitle());
                mv.addObject("blogSummary", data.getSummary());
                if (data.getState().equals(BlogStatusEnum.PRIVATE.getCode())) {
                    mv.addObject("blogIsPrivate", true);
                }
                mv.addObject("blogContentMd", StringUtils.stringToUnicode(data.getContentMd()));
            }

            ResultBean<BloggerStatisticsDTO> loginBgStat = statisticsService.getBloggerStatistics(bloggerId);
            mv.addObject("loginBgStat", loginBgStat.getData());

            mv.setViewName("/blogger/edit_blog");
        }

        return mv;
    }

}
