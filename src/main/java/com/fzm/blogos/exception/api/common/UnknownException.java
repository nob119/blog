package com.fzm.blogos.exception.api.common;

import com.fzm.blogos.exception.BaseRuntimeException;


public class UnknownException extends BaseRuntimeException {

    public static final int code = 10;

    public UnknownException(String message) {
        super(message, code);
    }

    public UnknownException() {
        super(code);
    }

    public UnknownException(String message, Throwable e) {
        super(message, e, code);
    }
}
