package com.fzm.blogos.service.impl.blogger;

import com.fzm.blogos.dao.blogger.BloggerSettingDao;
import com.fzm.blogos.entity.blogger.BloggerSetting;
import com.fzm.blogos.service.blogger.BloggerSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BloggerSettingServiceImpl implements BloggerSettingService {

    @Autowired
    private BloggerSettingDao settingDao;

    @Override
    public BloggerSetting getSetting(int bloggerId) {
        return settingDao.getSetting(bloggerId);
    }

    @Override
    public boolean updateMainPageNavPos(int bloggerId, int pos) {
        int effect = settingDao.updateMainPageNavPos(bloggerId, pos);
        if (effect <= 0) return false;

        return true;
    }

}
