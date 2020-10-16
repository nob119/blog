package com.fzm.blogos.dto.blogger;

import lombok.Data;

import java.io.Serializable;


@Data
public class BloggerBriefDTO implements Serializable {

    private static final long serialVersionUID = -5298929293069099257L;

    // 博主统计信息
    private BloggerStatisticsDTO statistics;

    // 博主 dto
    private BloggerDTO blogger;
}
