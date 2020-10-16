package com.fzm.blogos.exception.api.blogger;

import com.fzm.blogos.exception.BaseRuntimeException;


public class LoginFailException extends BaseRuntimeException {

    public static final int code = 20;

    public LoginFailException() {
        super(code);
    }

    public LoginFailException(String message) {
        super(message, code);
    }

    public LoginFailException(String message, Throwable cause) {
        super(message, cause, code);
    }
}
