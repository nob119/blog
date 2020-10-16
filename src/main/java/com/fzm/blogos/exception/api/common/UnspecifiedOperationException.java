package com.fzm.blogos.exception.api.common;

import com.fzm.blogos.exception.BaseRuntimeException;


public class UnspecifiedOperationException extends BaseRuntimeException {

    public static final int code = 9;

    public UnspecifiedOperationException() {
        super(code);
    }

    public UnspecifiedOperationException(String message) {
        super(message, code);
    }
}
