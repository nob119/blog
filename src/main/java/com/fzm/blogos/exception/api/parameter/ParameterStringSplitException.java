package com.fzm.blogos.exception.api.parameter;

import com.fzm.blogos.exception.BaseRuntimeException;


public class ParameterStringSplitException extends BaseRuntimeException {

    public static final int code = 2;

    public ParameterStringSplitException(String message) {
        super(message, code);
    }

    public ParameterStringSplitException() {
        super(code);
    }
}
