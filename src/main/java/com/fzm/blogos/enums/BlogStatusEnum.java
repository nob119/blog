package com.fzm.blogos.enums;


public enum BlogStatusEnum {

    /**
     * 博文是公开的，所有人都可以看到
     */
    PUBLIC(1),

    /**
     * 博文是私有的，只有博主才可以看到
     */
    PRIVATE(2),

    /**
     * 文章已经被删除了，根据回收策略进行删除
     */
    DELETED(3),

    /**
     * 正在审核
     */
    VERIFY(0);

    private final int code;

    BlogStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BlogStatusEnum valueOf(int code) {
        for (BlogStatusEnum anEnum : values()) {
            if (anEnum.getCode() == code)
                return anEnum;
        }
        return null;
    }
}