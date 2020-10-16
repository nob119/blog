package com.fzm.blogos.exception.internal;


public class SQLException extends InternalRuntimeException {

    public static final int code = 3;

    public SQLException() {
        super(code);
    }

    public SQLException(Throwable e) {
        super(e, code);
    }
}
