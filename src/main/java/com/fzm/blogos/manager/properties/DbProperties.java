package com.fzm.blogos.manager.properties;

import lombok.Data;


@Data
public class DbProperties {

    /**
     * 数据库数字间隔字符
     */
    private String stringFiledSplitCharacterForNumber;

    /**
     * 数据库字符串间隔字符
     */
    private String stringFiledSplitCharacterForString;

}
