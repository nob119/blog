package com.fzm.blogos.entity.blog;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class BlogLabel implements Serializable {

    private static final long serialVersionUID = 4565919455090875775L;

    //id
    private Integer id;

    //所属博主id
    private Integer bloggerId;

    //标题
    private String title;

    //创建时间
    private Timestamp createDate;

}
