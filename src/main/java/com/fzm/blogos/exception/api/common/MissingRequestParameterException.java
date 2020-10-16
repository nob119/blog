package com.fzm.blogos.exception.api.common;

import com.fzm.blogos.exception.BaseRuntimeException;


public class MissingRequestParameterException extends BaseRuntimeException {

    public static final int code = 16;

    public MissingRequestParameterException() {
        super(code);
    }

    public MissingRequestParameterException(String message) {
        super(message, code);
    }

    public MissingRequestParameterException(String message, Throwable cause) {
        super(message, cause, code);
    }

}
