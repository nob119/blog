package com.fzm.blogos.dao.blog;

import com.fzm.blogos.dao.BaseDao;
import com.fzm.blogos.entity.blog.BlogComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogCommentDao extends BaseDao<BlogComment> {

    /**
     * 根据博文id查询评论
     *
     * @param blogId 博文id
     * @param status 博文状态
     * @param offset 偏移位置
     * @param rows   行数
     * @return 查询结果
     */
    List<BlogComment> listCommentByBlogId(@Param("blogId") int blogId,
                                          @Param("offset") int offset,
                                          @Param("rows") int rows,
                                          @Param("status") int status);

    /**
     * 根据博文id获得所有针对该博文的评论
     *
     * @param blogId 博文id
     * @return 查询结果
     */
    List<BlogComment> listAllCommentByBlogId(int blogId);
}
