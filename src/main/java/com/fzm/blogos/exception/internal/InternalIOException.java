package com.fzm.blogos.exception.internal;


public class InternalIOException extends InternalRuntimeException {

    public static final int code = 2;

    public InternalIOException(Throwable e) {
        super(e, code);
    }

    public InternalIOException() {
        super(code);
    }
}
