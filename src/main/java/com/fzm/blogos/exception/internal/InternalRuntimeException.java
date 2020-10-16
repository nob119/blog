package com.fzm.blogos.exception.internal;

import com.fzm.blogos.exception.BaseRuntimeException;


public class InternalRuntimeException extends BaseRuntimeException {

    public InternalRuntimeException(int code) {
        super(code);
    }

    public InternalRuntimeException(String message, int code) {
        super(message, code);
    }

    public InternalRuntimeException(String message, Throwable cause, int code) {
        super(message, cause, code);
    }

    public InternalRuntimeException(Throwable cause, int code) {
        super(cause, code);
    }
}
