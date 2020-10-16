package com.fzm.blogos.web.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/help-feedback")
public class HelpAndFeedbackPageController {

    @RequestMapping("")
    public ModelAndView page(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("blogger/help_feedback");

        return mv;
    }
}
