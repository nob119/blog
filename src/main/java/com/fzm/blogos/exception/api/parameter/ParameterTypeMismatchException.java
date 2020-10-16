package com.fzm.blogos.exception.api.parameter;

import com.fzm.blogos.exception.BaseRuntimeException;


public class ParameterTypeMismatchException extends BaseRuntimeException {

    public static final int code = 19;

    public ParameterTypeMismatchException() {
        super(code);
    }

    public ParameterTypeMismatchException(String message) {
        super(message, code);
    }

    public ParameterTypeMismatchException(String message, Throwable cause) {
        super(message, cause, code);
    }
}
