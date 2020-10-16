package com.fzm.blogos.exception.api.blog;

import com.fzm.blogos.exception.BaseRuntimeException;


public class BlogSortOrderUndefinedException extends BaseRuntimeException {

    public static final int code = 12;

    public BlogSortOrderUndefinedException(String message) {
        super(message, code);
    }

    public BlogSortOrderUndefinedException() {
        super(code);
    }
}
