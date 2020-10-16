package com.fzm.blogos.exception.api.blogger;

import com.fzm.blogos.exception.BaseRuntimeException;


public class UnknownLinkException extends BaseRuntimeException {

    public static final int code = 17;

    public UnknownLinkException(String message) {
        super(message,code);
    }

    public UnknownLinkException() {
        super(code);
    }

    public UnknownLinkException(String message, Throwable e) {
        super(message, e,code);
    }
}
