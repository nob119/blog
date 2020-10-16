package com.fzm.blogos.dto.blogger;

import com.fzm.blogos.entity.blogger.BloggerPicture;
import lombok.Data;

import java.io.Serializable;


@Data
public class BloggerLinkDTO implements Serializable {

    private static final long serialVersionUID = -558005429949054040L;

    // id
    private int id;

    //博主id
    private int bloggerId;

    //图片
    private BloggerPicture icon;

    //标题
    private String title;

    //url
    private String url;

    //描述
    private String bewrite;

}
