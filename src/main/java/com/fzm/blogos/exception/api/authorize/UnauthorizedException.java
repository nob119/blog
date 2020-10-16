package com.fzm.blogos.exception.api.authorize;

import com.fzm.blogos.exception.BaseRuntimeException;


public class UnauthorizedException extends BaseRuntimeException {

    public static final int code = 4;

    public UnauthorizedException() {
        super(code);
    }

    public UnauthorizedException(String message) {
        super(message, code);
    }

    public UnauthorizedException(Throwable cause) {
        super(cause, code);
    }
}
