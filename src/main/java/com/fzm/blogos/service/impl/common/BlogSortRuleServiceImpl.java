package com.fzm.blogos.service.impl.common;

import com.fzm.blogos.common.Order;
import com.fzm.blogos.common.Rule;
import com.fzm.blogos.dto.blog.BlogSortRuleDTO;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.common.BlogSortRuleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class BlogSortRuleServiceImpl implements BlogSortRuleService {

    @Override
    public ResultBean<List<BlogSortRuleDTO>> listSortRule() {

        List<BlogSortRuleDTO> list = new ArrayList<>();
        Arrays.stream(Rule.values()).forEach(rule -> list.add(new BlogSortRuleDTO(rule.name().toLowerCase(), rule.title())));

        return new ResultBean<>(list);
    }

    @Override
    public ResultBean<List<BlogSortRuleDTO>> listSortOrder() {

        List<BlogSortRuleDTO> list = new ArrayList<>();
        Arrays.stream(Order.values()).forEach(order -> list.add(new BlogSortRuleDTO(order.name().toLowerCase(), order.title())));

        return new ResultBean<>(list);
    }
}
