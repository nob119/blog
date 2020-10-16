package com.fzm.blogos.service.impl.audience;

import com.fzm.blogos.dao.blog.BlogCategoryDao;
import com.fzm.blogos.dao.blog.BlogLabelDao;
import com.fzm.blogos.dto.blog.BlogListItemDTO;
import com.fzm.blogos.entity.blog.Blog;
import com.fzm.blogos.entity.blog.BlogCategory;
import com.fzm.blogos.entity.blog.BlogLabel;
import com.fzm.blogos.entity.blog.BlogStatistics;
import com.fzm.blogos.manager.DataFillingManager;
import com.fzm.blogos.manager.properties.DbProperties;
import com.fzm.blogos.restful.ResultBean;
import com.fzm.blogos.service.BlogFilterAbstract;
import com.fzm.blogos.service.audience.BlogRetrievalService;
import com.fzm.blogos.util.CollectionUtils;
import com.fzm.blogos.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class BlogRetrievalServiceImpl extends BlogFilterAbstract<ResultBean<List<BlogListItemDTO>>> implements
        BlogRetrievalService {

    @Autowired
    private BlogCategoryDao categoryDao;

    @Autowired
    private BlogLabelDao labelDao;

    @Autowired
    private DataFillingManager dataFillingManager;

    @Autowired
    private DbProperties dbProperties;

    @Override
    protected ResultBean<List<BlogListItemDTO>> constructResult(Map<Integer, Blog> blogHashMap,
                                                                List<BlogStatistics> statistics,
                                                                Map<Integer, int[]> blogIdMapCategoryIds,
                                                                Map<Integer, String> blogImgs) {

        // 重组结果
        List<BlogListItemDTO> result = new ArrayList<>();
        String ch = dbProperties.getStringFiledSplitCharacterForNumber();

        for (BlogStatistics ss : statistics) {
            Integer blogId = ss.getBlogId();
            Blog blog = blogHashMap.get(blogId);

            // category
            int[] cids = blogIdMapCategoryIds.get(blogId);
            List<BlogCategory> categories = null;
            if (!CollectionUtils.isEmpty(cids)) {
                categories = categoryDao.listCategoryById(cids);
            }

            // label
            int[] lids = StringUtils.intStringDistinctToArray(blog.getLabelIds(), ch);
            List<BlogLabel> labels = null;
            if (!CollectionUtils.isEmpty(lids)) {
                labels = labelDao.listLabelById(lids);
            }

            String blogImg = blogImgs.get(blogId);
            BlogListItemDTO dto = dataFillingManager.blogListItemToDTO(ss,
                    CollectionUtils.isEmpty(categories) ? null : categories.toArray(new BlogCategory[categories.size()]),
                    CollectionUtils.isEmpty(labels) ? null : labels.toArray(new BlogLabel[labels.size()]),
                    blog, blogImg);

            result.add(dto);
        }

        return new ResultBean<>(result);

    }
}
