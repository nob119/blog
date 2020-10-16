package com.fzm.blogos.service.common;

import com.fzm.blogos.dto.blog.BlogSortRuleDTO;
import com.fzm.blogos.restful.ResultBean;

import java.util.List;


public interface BlogSortRuleService {

    /**
     * 获得所有的排序规则
     *
     * @return 结果
     */
    ResultBean<List<BlogSortRuleDTO>> listSortRule();

    /**
     * 获得排序顺序
     *
     * @return 结果
     */
    ResultBean<List<BlogSortRuleDTO>> listSortOrder();

}
