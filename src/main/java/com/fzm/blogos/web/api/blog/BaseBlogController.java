package com.fzm.blogos.web.api.blog;

import com.fzm.blogos.manager.properties.AudienceProperties;
import com.fzm.blogos.web.api.BaseCheckController;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseBlogController extends BaseCheckController {

    @Autowired
    protected AudienceProperties audienceProperties;

}
