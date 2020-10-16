package com.fzm.blogos.web.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")
public class RegisterPageController {

    @RequestMapping
    public String registerPage() {
        return "blogger/register";
    }
}
