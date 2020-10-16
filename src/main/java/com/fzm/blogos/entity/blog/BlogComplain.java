package com.fzm.blogos.entity.blog;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class BlogComplain implements Serializable {

    private static final long serialVersionUID = -2651098932919577290L;

    //表id
    private Integer id;

    //投诉的博文id
    private Integer blogId;

    //投诉者id
    private Integer complainerId;

    //投诉内容
    private String content;

    //投诉时间
    private Timestamp time;
}
