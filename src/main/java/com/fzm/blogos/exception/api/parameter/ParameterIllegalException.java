package com.fzm.blogos.exception.api.parameter;

import com.fzm.blogos.exception.BaseRuntimeException;


public class ParameterIllegalException extends BaseRuntimeException {

    public static final int code = 3;

    public ParameterIllegalException() {
        super(code);
    }

    public ParameterIllegalException(String message) {
        super(message, code);
    }
}
