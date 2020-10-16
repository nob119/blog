package com.fzm.blogos.web.api.blogger;

import com.fzm.blogos.common.BlogSortRule;
import com.fzm.blogos.common.Order;
import com.fzm.blogos.common.Rule;
import com.fzm.blogos.dto.blogger.FavouriteBlogListItemDTO;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.blogger.BloggerLikeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/blogger/{bloggerId}/like")
public class BloggerLikeBlogController extends BaseBloggerController {

    @Autowired
    private BloggerLikeBlogService likeBlogService;

    /**
     * 收藏博文清单
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResultBean<List<FavouriteBlogListItemDTO>> list(HttpServletRequest request,
                                                           @PathVariable("bloggerId") Integer bloggerId,
                                                           @RequestParam(value = "offset", required = false) Integer offset,
                                                           @RequestParam(value = "rows", required = false) Integer rows,
                                                           @RequestParam(value = "sort", required = false) String sort,
                                                           @RequestParam(value = "order", required = false) String order) {
        final RequestContext context = new RequestContext(request);
        handleAccountCheck(request, bloggerId);

        //检查数据合法性
        String sor = sort == null ? Rule.VIEW_COUNT.name() : sort.toUpperCase();
        String ord = order == null ? Order.DESC.name() : order.toUpperCase();
        if (!Rule.contains(sor)) throw exceptionManager.getBlogSortRuleUndefinedException(context);
        if (!Order.contains(ord)) throw exceptionManager.getBlogSortOrderUndefinedException(context);

        int os = offset == null || offset < 0 ? 0 : offset;
        int rs = rows == null || rows < 0 ? bloggerProperties.getRequestBloggerCollectCount() : rows;

        // 查询数据
        ResultBean<List<FavouriteBlogListItemDTO>> result = likeBlogService.listLikeBlog(bloggerId, os, rs,
                BlogSortRule.valueOf(sor, ord));
        if (result == null) handlerEmptyResult(request);

        return result;
    }


    /**
     * 统计收藏收藏量
     */
    @RequestMapping("/count")
    public ResultBean count(HttpServletRequest request,
                            @PathVariable("bloggerId") Integer bloggerId) {

        handleAccountCheck(request, bloggerId);

        return new ResultBean<>(likeBlogService.countByBloggerId(bloggerId));
    }
}
