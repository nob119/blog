package com.fzm.blogos.exception.api.common;

import com.fzm.blogos.exception.BaseRuntimeException;


public class DuplicationDataException extends BaseRuntimeException {

    public static final int code = 18;

    public DuplicationDataException() {
        super(code);
    }

    public DuplicationDataException(String message) {
        super(message, code);
    }

    public DuplicationDataException(String message, Throwable cause) {
        super(message, cause, code);
    }
}
