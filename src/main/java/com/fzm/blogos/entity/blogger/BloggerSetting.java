package com.fzm.blogos.entity.blogger;

import lombok.Data;


@Data
public class BloggerSetting {

    // id
    private Integer id;

    // 博主id
    private Integer bloggerId;

    // 博主主页个人信息栏位置，0为左，1为右
    private Integer mainPageNavPos;
}
