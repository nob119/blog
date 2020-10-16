package com.fzm.blogos.exception.api.blog;

import com.fzm.blogos.exception.BaseRuntimeException;


public class BlogSortRuleUndefinedException extends BaseRuntimeException {

    public static final int code = 13;

    public BlogSortRuleUndefinedException(String message) {
        super(message, code);
    }

    public BlogSortRuleUndefinedException() {
        super(code);
    }
}
