package com.fzm.blogos.exception.internal;


public class UnknownInternalException extends InternalRuntimeException {

    public static final int code = 21;

    public UnknownInternalException(Throwable cause) {
        super(cause, code);
    }
}
