package com.fzm.blogos.web.api.blog;

import com.fzm.blogos.dto.blog.BlogCommentDTO;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.audience.BlogBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/blog/{blogId}/comment")
public class BlogCommentController extends BaseBlogController {

    @Autowired
    private BlogBrowseService blogBrowseService;

    /**
     * 获得博文评论列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<List<BlogCommentDTO>> get(HttpServletRequest request,
                                                @PathVariable Integer blogId,
                                                @RequestParam(value = "offset", required = false) Integer offset,
                                                @RequestParam(value = "rows", required = false) Integer rows) {
        handleBlogExistCheck(request, blogId);

        int os = offset == null || offset < 0 ? 0 : offset;
        int rs = rows == null || rows < 0 ? audienceProperties.getRequestBloggerBlogCommentCount() : rows;
        ResultBean<List<BlogCommentDTO>> resultBean = blogBrowseService.listBlogComment(blogId, os, rs);
        if (resultBean == null) handlerEmptyResult(request);

        return resultBean;
    }

}
