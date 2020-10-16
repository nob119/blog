package com.fzm.blogos.service.impl.audience;

import com.fzm.blogos.dao.blog.BlogCategoryDao;
import com.fzm.blogos.dao.blog.BlogCommentDao;
import com.fzm.blogos.dao.blog.BlogDao;
import com.fzm.blogos.dao.blog.BlogLabelDao;
import com.fzm.blogos.dao.blogger.BloggerAccountDao;
import com.fzm.blogos.dao.blogger.BloggerPictureDao;
import com.fzm.blogos.dao.blogger.BloggerProfileDao;
import com.fzm.blogos.dto.blog.BlogCommentDTO;
import com.fzm.blogos.dto.blog.BlogMainContentDTO;
import com.fzm.blogos.dto.blogger.BloggerDTO;
import com.fzm.blogos.entity.blog.Blog;
import com.fzm.blogos.entity.blog.BlogCategory;
import com.fzm.blogos.entity.blog.BlogComment;
import com.fzm.blogos.entity.blog.BlogLabel;
import com.fzm.blogos.entity.blogger.BloggerAccount;
import com.fzm.blogos.entity.blogger.BloggerPicture;
import com.fzm.blogos.entity.blogger.BloggerProfile;
import com.fzm.blogos.enums.BlogCommentStatusEnum;
import com.fzm.blogos.manager.DataFillingManager;
import com.fzm.blogos.manager.StringConstructorManager;
import com.fzm.blogos.manager.properties.BloggerProperties;
import com.fzm.blogos.manager.properties.DbProperties;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.audience.BlogBrowseService;
import com.fzm.blogos.util.CollectionUtils;
import com.fzm.blogos.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.fzm.blogos.enums.BloggerPictureCategoryEnum.DEFAULT_BLOGGER_AVATAR;


@Service
public class BlogBrowseServiceImpl implements BlogBrowseService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private BlogCategoryDao categoryDao;

    @Autowired
    private BlogLabelDao labelDao;

    @Autowired
    private DbProperties dbProperties;

    @Autowired
    private DataFillingManager dataFillingManager;

    @Autowired
    private StringConstructorManager constructorManager;

    @Autowired
    private BloggerProperties bloggerProperties;

    @Autowired
    private BlogCommentDao commentDao;

    @Autowired
    private BloggerAccountDao accountDao;

    @Autowired
    private BloggerPictureDao pictureDao;

    @Autowired
    private BloggerProfileDao profileDao;

    @Override
    public ResultBean<BlogMainContentDTO> getBlogMainContent(int blogId) {

        //查询数据
        Blog blog = blogDao.getBlogById(blogId);
        if (blog == null) return null;
        String ch = dbProperties.getStringFiledSplitCharacterForNumber();
        int[] cids = StringUtils.intStringDistinctToArray(blog.getCategoryIds(), ch);
        int[] lids = StringUtils.intStringDistinctToArray(blog.getLabelIds(), ch);
        List<BlogCategory> categories = cids == null ? null : categoryDao.listCategoryById(cids);
        List<BlogLabel> labels = lids == null ? null : labelDao.listLabelById(lids);

        //填充数据
        String sc = dbProperties.getStringFiledSplitCharacterForString();
        BlogMainContentDTO dto = dataFillingManager.blogMainContentToDTO(blog, categories, labels, sc);

        return new ResultBean<>(dto);
    }

    @Override
    public ResultBean<List<BlogCommentDTO>> listBlogComment(int blogId, int offset, int rows) {

        List<BlogCommentDTO> result = new ArrayList<>();

        List<BlogComment> comments = commentDao.listCommentByBlogId(blogId, offset, rows,
                BlogCommentStatusEnum.RIGHTFUL.getCode());
        for (BlogComment comment : comments) {

            //评论者数据
            int sid = comment.getSpokesmanId();
            BloggerAccount smAccount = accountDao.getAccountById(sid);
            BloggerProfile smProfile = getProfile(sid);
            BloggerDTO smDTO = dataFillingManager.bloggerAccountToDTO(smAccount, smProfile,
                    getAvatar(smProfile.getAvatarId()));

            BlogCommentDTO dto = dataFillingManager.blogCommentToDTO(comment, smDTO);
            result.add(dto);
        }

        return CollectionUtils.isEmpty(result) ? null : new ResultBean<>(result);
    }

    private BloggerPicture getAvatar(Integer id) {
        BloggerPicture avatar;
        if (id != null) {
            avatar = pictureDao.getPictureById(id);
        } else {
            avatar = pictureDao.getBloggerUniquePicture(bloggerProperties.getPictureManagerBloggerId(),
                    DEFAULT_BLOGGER_AVATAR.getCode());
        }

        if (avatar != null) {
            avatar.setPath(constructorManager.constructPictureUrl(avatar, DEFAULT_BLOGGER_AVATAR));
        }

        return avatar;
    }


    //获得博主资料
    private BloggerProfile getProfile(Integer bloggerId) {
        if (bloggerId == null) return null;
        return profileDao.getProfileByBloggerId(bloggerId);
    }
}
