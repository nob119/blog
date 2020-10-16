package com.fzm.blogos.service.impl.blogger;

import com.fzm.blogos.dao.blog.BlogCommentDao;
import com.fzm.blogos.dao.blog.BlogStatisticsDao;
import com.fzm.blogos.entity.blog.BlogComment;
import com.fzm.blogos.service.blogger.BloggerCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BloggerCommentServiceImpl implements BloggerCommentService {

    @Autowired
    private BlogStatisticsDao statisticsDao;

    @Autowired
    private BlogCommentDao commentDao;

    @Override
    public int insertComment(int blogId, int spokesmanId, int listenerId, int state, String content) {

        BlogComment comment = new BlogComment();
        comment.setBlogId(blogId);
        comment.setContent(content);
        comment.setListenerId(listenerId);
        comment.setSpokesmanId(spokesmanId);
        comment.setState(state);
        commentDao.insert(comment);

        //博文评论次数加一
        statisticsDao.updateCommentCountPlus(blogId);
        Integer id = comment.getId();

        return id == null ? -1 : id;
    }

    @Override
    public boolean deleteComment(int commentId, int blogId) {

        int effect = commentDao.delete(commentId);

        if (effect <= 0) return false;
        else statisticsDao.updateCommentCountMinus(blogId);

        return true;
    }

}
