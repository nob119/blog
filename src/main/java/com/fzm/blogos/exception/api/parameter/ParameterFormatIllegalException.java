package com.fzm.blogos.exception.api.parameter;

import com.fzm.blogos.exception.BaseRuntimeException;


public class ParameterFormatIllegalException extends BaseRuntimeException {

    public static final int code = 3;

    public ParameterFormatIllegalException() {
        super(code);
    }

    public ParameterFormatIllegalException(String message) {
        super(message, code);
    }
}
