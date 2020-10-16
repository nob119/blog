package com.fzm.blogos.dto.blogger;

import com.fzm.blogos.entity.blogger.BloggerPicture;
import com.fzm.blogos.entity.blogger.BloggerProfile;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class BloggerDTO implements Serializable {

    private static final long serialVersionUID = 4552057430001933904L;

    //id
    private int id;

    //个人资料
    private BloggerProfile profile;

    //博主头像（需要单独从相册中查询）
    private BloggerPicture avatar;

    //用户名
    private String username;

    //注册时间
    private Timestamp registerDate;

}
