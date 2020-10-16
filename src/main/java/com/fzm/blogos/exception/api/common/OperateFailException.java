package com.fzm.blogos.exception.api.common;

import com.fzm.blogos.exception.BaseRuntimeException;

public class OperateFailException extends BaseRuntimeException {

    public static final int code = 18;

    public OperateFailException() {
        super(code);
    }

    public OperateFailException(String message) {
        super(message, code);
    }

    public OperateFailException(String message, Throwable e) {
        super(message, e, code);
    }
}
