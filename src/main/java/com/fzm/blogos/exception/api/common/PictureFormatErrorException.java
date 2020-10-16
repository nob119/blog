package com.fzm.blogos.exception.api.common;

import com.fzm.blogos.exception.BaseRuntimeException;


public class PictureFormatErrorException extends BaseRuntimeException {

    public static final int code = 22;

    public PictureFormatErrorException() {
        super(code);
    }

    public PictureFormatErrorException(String message) {
        super(message, code);
    }

    public PictureFormatErrorException(String message, Throwable e) {
        super(message, e, code);
    }
}
