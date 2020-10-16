package com.fzm.blogos.web.blog;

import com.fzm.blogos.dto.blogger.BloggerStatisticsDTO;
import com.fzm.blogos.entity.blogger.BloggerAccount;
import com.fzm.blogos.entity.blogger.BloggerProfile;
import com.fzm.blogos.entity.blogger.BloggerSetting;
import com.fzm.blogos.enums.BloggerPictureCategoryEnum;
import com.fzm.blogos.exception.api.blogger.UnknownBloggerException;
import com.fzm.blogos.manager.BloggerSessionManager;
import com.fzm.blogos.manager.properties.BloggerProperties;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.blogger.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


@Controller
@RequestMapping("/{bloggerName}")
public class BloggerPageController {

    @Autowired
    private BloggerAccountService accountService;

    @Autowired
    private BloggerProfileService bloggerProfileService;

    @Autowired
    private BloggerStatisticsService statisticsService;

    @Autowired
    private BloggerPictureService bloggerPictureService;

    @Autowired
    private BloggerProperties bloggerProperties;

    @Autowired
    private BloggerSessionManager sessionManager;

    @Autowired
    private BloggerSettingService settingService;

    @RequestMapping("/archives")
    public ModelAndView mainPage(HttpServletRequest request,
                                 @PathVariable String bloggerName) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("blogger/main");

        BloggerAccount account = accountService.getAccount(bloggerName);
        if (account == null) {
            request.setAttribute("code", UnknownBloggerException.code);
            mv.setViewName("/blogger/register");
            return mv;
        }

        mv.addObject(bloggerProperties.getNameOfPageOwnerBloggerId(), account.getId());
        mv.addObject(bloggerProperties.getNameOfPageOwnerBloggerName(), account.getUsername());

        int ownerId = account.getId();
        BloggerProfile profile = bloggerProfileService.getBloggerProfile(ownerId);
        mv.addObject("blogName", profile.getIntro());
        mv.addObject("aboutMe", profile.getAboutMe());
        mv.addObject("avatarId",
                Optional.ofNullable(profile.getAvatarId())
                        .orElse(bloggerPictureService
                                .getDefaultPicture(BloggerPictureCategoryEnum.DEFAULT_BLOGGER_AVATAR)
                                .getId()));


        ResultBean<BloggerStatisticsDTO> ownerBgStat = statisticsService.getBloggerStatistics(ownerId);
        mv.addObject("ownerBgStat", ownerBgStat.getData());

        int loginBgId;
        if ((loginBgId = sessionManager.getLoginBloggerId(request)) != -1) {
            ResultBean<BloggerStatisticsDTO> loginBgStat = statisticsService.getBloggerStatistics(loginBgId);
            mv.addObject("loginBgStat", loginBgStat.getData());
        }

        BloggerSetting setting = settingService.getSetting(ownerId);
        mv.addObject("setting", setting);

        return mv;
    }

}
