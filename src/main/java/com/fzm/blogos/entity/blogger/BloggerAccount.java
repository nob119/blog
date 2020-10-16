package com.fzm.blogos.entity.blogger;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class BloggerAccount implements Serializable {

    private static final long serialVersionUID = -1326020643799217215L;

    //id
    private Integer id;

    //用户名
    private String username;

    //密码
    private String password;

    //注册时间
    private Timestamp registerDate;

}
