package com.fzm.blogos.manager.comparator;

import com.fzm.blogos.common.Order;
import com.fzm.blogos.common.Rule;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public abstract class BlogComparatorFactoryAbstract<T> {

    private Map<Rule, Comparator<T>> coms = new HashMap<>();
    Order order = Order.ASC;

    BlogComparatorFactoryAbstract() {
        initFactory();
    }

    /**
     * 初始所有备用比较器
     */
    protected abstract void initFactory();

    public Comparator<T> get(Rule rule, Order order) {
        this.order = order;
        return coms.get(rule);
    }

    void add(Rule key, Comparator<T> comparator) {
        coms.put(key, comparator);
    }

}
