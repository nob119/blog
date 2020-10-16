package com.fzm.blogos.dto.blog;

import com.fzm.blogos.dto.blogger.BloggerDTO;
import com.fzm.blogos.entity.blog.BlogCategory;
import com.fzm.blogos.entity.blog.BlogLabel;
import com.fzm.blogos.entity.blog.BlogStatistics;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
public class BlogStatisticsDTO implements Serializable {

    private static final long serialVersionUID = 1258582482361980014L;

    //博文id
    private int id;

    //统计信息
    private BlogStatistics statistics;

    //博文所属类别
    private BlogCategory[] categories;

    //博文标签
    private BlogLabel[] labels;

    //状态
    private int state;

    //博文标题
    private String title;

    //博文摘要
    private String summary;

    //博文关键字
    private String[] keyWords;

    //首次发布日期
    private Timestamp releaseDate;

    //最近修改日期
    private Timestamp nearestModifyDate;

    //字数
    private int wordCount;

    //喜欢该篇文章的人
    private BloggerDTO[] likes;

    //收藏了该篇文章的人
    private BloggerDTO[] collects;

    //评论了该篇文章的人
    private BloggerDTO[] commenter;

}
