package com.fzm.blogos.exception.internal;


public class LuceneException extends InternalRuntimeException {

    public static final int code = 1;

    public LuceneException(Throwable e) {
        super(e, code);
    }
}
