package com.fzm.blogos.service.audience;

import com.fzm.blogos.dto.blog.BlogListItemDTO;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.BlogFilter;

import java.util.List;

/**
 * 博文检索并排序服务
 * <p>
 * 1 全限定检索
 * 2 关键字检索
 * 3 类别检索
 * 4 标签检索
 *
 */
public interface BlogRetrievalService extends BlogFilter<ResultBean<List<BlogListItemDTO>>> {

}
