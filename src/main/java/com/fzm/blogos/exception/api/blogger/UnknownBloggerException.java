package com.fzm.blogos.exception.api.blogger;

import com.fzm.blogos.exception.BaseRuntimeException;


public class UnknownBloggerException extends BaseRuntimeException {

    public static final int code = 6;

    public UnknownBloggerException(String message) {
        super(message,code);
    }

    public UnknownBloggerException() {
        super(code);
    }
}
