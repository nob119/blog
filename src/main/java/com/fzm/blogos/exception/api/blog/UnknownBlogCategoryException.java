package com.fzm.blogos.exception.api.blog;

import com.fzm.blogos.exception.BaseRuntimeException;


public class UnknownBlogCategoryException extends BaseRuntimeException {

    public static final int code = 7;

    public UnknownBlogCategoryException(String message) {
        super(message,code);
    }

    public UnknownBlogCategoryException() {
        super(code);
    }
}
