package com.fzm.blogos.web.api;

import com.fzm.blogos.restful.ResultBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/blogger/{bloggerId}/logout")
public class BloggerLogoutController extends BaseCheckController {


    @RequestMapping(method = RequestMethod.POST)
    public ResultBean logout(HttpServletRequest request,
                             @PathVariable Integer bloggerId) {
        handleBloggerSignInCheck(request, bloggerId);
        request.getSession().invalidate();

        return new ResultBean<>("");
    }

}
