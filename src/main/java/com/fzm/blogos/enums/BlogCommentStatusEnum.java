package com.fzm.blogos.enums;


public enum BlogCommentStatusEnum {

    /**
     * 正在审核
     */
    BEING_AUDITED(0),

    /**
     * 审核通过
     */
    RIGHTFUL(1);

    private final int code;

    BlogCommentStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
