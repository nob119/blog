package com.fzm.blogos.common;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class BlogSortRule {

    /**
     * 排序依据
     */
    private final Rule rule;

    /**
     * 升序或降序
     */
    private final Order order;

    public static BlogSortRule valueOf(String ruleName, String orderName) {
        Rule rule = Rule.valueOf(ruleName);
        Order order = Order.valueOf(orderName);
        return new BlogSortRule(rule, order);
    }

}
