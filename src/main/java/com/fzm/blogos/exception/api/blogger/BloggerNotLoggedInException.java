package com.fzm.blogos.exception.api.blogger;

import com.fzm.blogos.exception.BaseRuntimeException;


public class BloggerNotLoggedInException extends BaseRuntimeException {

    public static final int code = 1;

    public BloggerNotLoggedInException() {
        super(code);
    }

    public BloggerNotLoggedInException(String message) {
        super(message, code);
    }

    public BloggerNotLoggedInException(String message, Throwable cause) {
        super(message, cause, code);
    }

}
