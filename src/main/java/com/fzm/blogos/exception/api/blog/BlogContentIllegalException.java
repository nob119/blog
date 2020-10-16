package com.fzm.blogos.exception.api.blog;

import com.fzm.blogos.exception.BaseRuntimeException;


public class BlogContentIllegalException extends BaseRuntimeException {

    public static final int code = 11;

    public BlogContentIllegalException(String message) {
        super(message, code);
    }

    public BlogContentIllegalException() {
        super(code);
    }
}
