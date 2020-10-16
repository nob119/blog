package com.fzm.blogos.service.impl.blogger;

import com.fzm.blogos.dao.blog.*;
import com.fzm.blogos.dao.blogger.BloggerAccountDao;
import com.fzm.blogos.dao.blogger.BloggerLinkDao;
import com.fzm.blogos.dao.blogger.BloggerPictureDao;
import com.fzm.blogos.dao.blogger.BloggerProfileDao;
import com.fzm.blogos.dto.blogger.BloggerDTO;
import com.fzm.blogos.dto.blogger.BloggerStatisticsDTO;
import com.fzm.blogos.entity.blog.Blog;
import com.fzm.blogos.entity.blogger.BloggerAccount;
import com.fzm.blogos.entity.blogger.BloggerPicture;
import com.fzm.blogos.entity.blogger.BloggerProfile;
import com.fzm.blogos.enums.BlogStatusEnum;
import com.fzm.blogos.enums.BloggerPictureCategoryEnum;
import com.fzm.blogos.manager.DataFillingManager;
import com.fzm.blogos.manager.StringConstructorManager;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.blogger.BloggerStatisticsService;
import com.fzm.blogos.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class BloggerStatisticsServiceImpl implements BloggerStatisticsService {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private BlogLikeDao likeDao;

    @Autowired
    private BloggerLinkDao linkDao;

    @Autowired
    private BlogCategoryDao categoryDao;

    @Autowired
    private BlogLabelDao labelDao;

    @Autowired
    private BlogCollectDao collectDao;

    @Autowired
    private BlogStatisticsDao statisticsDao;

    @Autowired
    private DataFillingManager dataFillingManager;

    @Autowired
    private StringConstructorManager stringConstructorManager;

    @Autowired
    private BloggerAccountDao accountDao;

    @Autowired
    private BloggerPictureDao pictureDao;

    @Autowired
    private BloggerProfileDao profileDao;
    @Override
    public ResultBean<BloggerStatisticsDTO> getBloggerStatistics(int bloggerId) {

        int blogCount = blogDao.countBlogByBloggerId(bloggerId, BlogStatusEnum.PUBLIC.getCode());

        List<Blog> blogs = blogDao.listAllWordCountByBloggerId(bloggerId, BlogStatusEnum.PUBLIC.getCode());
        int wordCountSum = blogs.stream().mapToInt(Blog::getWordCount).sum();
        int likeCount = blogs.stream().mapToInt(Blog::getId).map(statisticsDao::getLikeCount).sum();

        int likeGiveCount = likeDao.countLikeByLikerId(bloggerId);

        int categoryCount = categoryDao.countByBloggerId(bloggerId);

        int labelCount = labelDao.countByBloggerId(bloggerId);

        int collectCount = collectDao.countByCollectorId(bloggerId);
        int collectedCount = blogs.stream().mapToInt(Blog::getId).map(statisticsDao::getCollectCount).sum();

        int linkCount = linkDao.countLinkByBloggerId(bloggerId);

        BloggerStatisticsDTO dto = dataFillingManager.bloggerStatisticToDTO(blogCount, wordCountSum, likeCount, likeGiveCount,
                categoryCount, labelCount, collectCount, collectedCount,linkCount);

        return new ResultBean<>(dto);
    }

    // 获得博主dto
    @Override
    public BloggerDTO[] listBloggerDTO(int... ids) {
        if (CollectionUtils.isEmpty(ids)) return null;

        BloggerDTO[] dtos = new BloggerDTO[ids.length];
        int c = 0;
        for (int id : ids) {
            BloggerAccount account = accountDao.getAccountById(id);
            BloggerProfile profile = profileDao.getProfileByBloggerId(id);
            BloggerPicture avatar = null;
            Integer avatarId = profile.getAvatarId();
            if (avatarId != null)
                avatar = pictureDao.getPictureById(avatarId);

            if (avatar != null)
                avatar.setPath(stringConstructorManager.constructPictureUrl(avatar, BloggerPictureCategoryEnum.DEFAULT_BLOGGER_AVATAR));

            // 设置默认头像
            if (avatar == null) {
                avatar = new BloggerPicture();
                avatar.setBloggerId(id);
                avatar.setCategory(BloggerPictureCategoryEnum.PUBLIC.getCode());
                avatar.setId(-1);
                avatar.setPath(stringConstructorManager.constructPictureUrl(avatar, BloggerPictureCategoryEnum.DEFAULT_BLOGGER_AVATAR));
            }

            BloggerDTO dto = dataFillingManager.bloggerAccountToDTO(account, profile, avatar);
            dtos[c++] = dto;
        }

        return Arrays.copyOf(dtos, c);
    }


}