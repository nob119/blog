package com.fzm.blogos.exception.api.blog;

import com.fzm.blogos.exception.BaseRuntimeException;


public class UnknownBlogException extends BaseRuntimeException {

    public static final int code = 5;

    public UnknownBlogException(String message) {
        super(message,code);
    }

    public UnknownBlogException() {
        super(code);
    }
}
