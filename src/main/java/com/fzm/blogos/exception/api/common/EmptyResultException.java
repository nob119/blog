package com.fzm.blogos.exception.api.common;

import com.fzm.blogos.exception.BaseRuntimeException;


public class EmptyResultException extends BaseRuntimeException {

    public static final int code = 14;

    public EmptyResultException() {
        super(code);
    }

    public EmptyResultException(String message) {
        super(message, code);
    }
}
