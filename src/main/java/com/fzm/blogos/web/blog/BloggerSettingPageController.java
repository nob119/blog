package com.fzm.blogos.web.blog;

import com.fzm.blogos.entity.blogger.BloggerAccount;
import com.fzm.blogos.entity.blogger.BloggerPicture;
import com.fzm.blogos.entity.blogger.BloggerProfile;
import com.fzm.blogos.entity.blogger.BloggerSetting;
import com.fzm.blogos.enums.BloggerPictureCategoryEnum;
import com.fzm.blogos.exception.api.blogger.UnknownBloggerException;
import com.fzm.blogos.manager.validate.BloggerValidateManager;
import com.fzm.blogos.service.blogger.BloggerAccountService;
import com.fzm.blogos.service.blogger.BloggerPictureService;
import com.fzm.blogos.service.blogger.BloggerProfileService;
import com.fzm.blogos.service.blogger.BloggerSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/{bloggerName}/setting")
public class BloggerSettingPageController {

    @Autowired
    private BloggerAccountService accountService;

    @Autowired
    private BloggerProfileService profileService;

    @Autowired
    private BloggerValidateManager bloggerValidateManager;

    @Autowired
    private BloggerPictureService pictureService;

    @Autowired
    private BloggerSettingService settingService;

    @RequestMapping
    public ModelAndView pageSetting(HttpServletRequest request,
                                    @ModelAttribute
                                    @PathVariable String bloggerName) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/blogger/setting");

        BloggerAccount account = accountService.getAccount(bloggerName);
        int bloggerId;
        if (account == null) {
            request.setAttribute("code", UnknownBloggerException.code);
            mv.setViewName("/blogger/register");
            return mv;
        } else if (!bloggerValidateManager.checkBloggerSignIn(request, bloggerId = account.getId())) {
            return new ModelAndView("redirect:/login");
        }

        BloggerProfile profile = profileService.getBloggerProfile(bloggerId);
        if (profile.getAvatarId() == null) {
            BloggerPicture picture = pictureService.getDefaultPicture(BloggerPictureCategoryEnum.DEFAULT_BLOGGER_AVATAR);
            profile.setAvatarId(picture.getId());
        }
        mv.addObject("profile", profile);

        BloggerSetting setting = settingService.getSetting(bloggerId);
        mv.addObject("setting", setting);

        return mv;
    }

}
