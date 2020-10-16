package com.fzm.blogos.exception.api.blogger;

import com.fzm.blogos.exception.BaseRuntimeException;


public class UnknownPictureException extends BaseRuntimeException {

    public static final int code = 8;

    public UnknownPictureException(String message) {
        super(message,code);
    }

    public UnknownPictureException() {
        super(code);
    }

    public UnknownPictureException(String message, Throwable e) {
        super(message, e,code);
    }
}
