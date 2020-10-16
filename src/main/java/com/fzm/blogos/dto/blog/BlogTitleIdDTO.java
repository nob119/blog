package com.fzm.blogos.dto.blog;

import lombok.Data;

import java.io.Serializable;


@Data
public class BlogTitleIdDTO implements Serializable {

    private static final long serialVersionUID = -7530640518956302887L;

    private String title;

    private int id;

}
