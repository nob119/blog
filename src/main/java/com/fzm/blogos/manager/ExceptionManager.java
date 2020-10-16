package com.fzm.blogos.manager;

import com.fzm.blogos.exception.BaseRuntimeException;
import com.fzm.blogos.exception.api.authorize.UnauthorizedException;
import com.fzm.blogos.exception.api.blog.*;
import com.fzm.blogos.exception.api.blogger.*;
import com.fzm.blogos.exception.api.common.*;
import com.fzm.blogos.exception.api.parameter.ParameterFormatIllegalException;
import com.fzm.blogos.exception.api.parameter.ParameterIllegalException;
import com.fzm.blogos.exception.api.parameter.ParameterStringSplitException;
import com.fzm.blogos.exception.api.parameter.ParameterTypeMismatchException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContext;


@Component
public class ExceptionManager {

    public BaseRuntimeException getEmptyResultException(RequestContext context) {
        return new EmptyResultException(context.getMessage("common.emptyResult"));
    }

    public BaseRuntimeException getUnknownBlogException(RequestContext context) {
        return new UnknownBlogException(context.getMessage("blog.unknownBlog"));
    }

    public BaseRuntimeException getUnknownBloggerException(RequestContext context) {
        return new UnknownBloggerException(context.getMessage("blogger.unknownBlogger"));
    }

    public BaseRuntimeException getParameterStringSplitException(RequestContext context) {
        return new ParameterStringSplitException(context.getMessage("common.parameterStringSplitIllegal"));
    }

    public BaseRuntimeException getBlogSortRuleUndefinedException(RequestContext context) {
        return new BlogSortRuleUndefinedException(context.getMessage("blog.blogSortRuleUndefined"));
    }

    public BaseRuntimeException getBlogSortOrderUndefinedException(RequestContext context) {
        return new BlogSortOrderUndefinedException(context.getMessage("blog.blogSortOrderUndefined"));
    }

    public BaseRuntimeException getParameterIllegalException(RequestContext context) {
        return new ParameterIllegalException(context.getMessage("common.parameterIllegal"));
    }

    public BaseRuntimeException getOperateFailException(RequestContext context) {
        return new OperateFailException(context.getMessage("common.operateFail"));
    }

    public BaseRuntimeException getUnspecifiedOperationException(RequestContext context) {
        return new UnspecifiedOperationException(context.getMessage("common.unspecifiedOperation"));
    }

    public BaseRuntimeException getUnknownException(RequestContext context, Throwable e) {
        return new UnknownException(context.getMessage("common.UnknownError"), e);
    }

    public BaseRuntimeException getMissingRequestParameterException(RequestContext context, Throwable e) {
        return new MissingRequestParameterException(context.getMessage("common.missingRequestParameter"), e);
    }

    public BaseRuntimeException getUnknownPictureException(RequestContext context) {
        return new UnknownPictureException(context.getMessage("common.unknownPicture"));
    }

    public BaseRuntimeException getUnknownLinkException(RequestContext context) {
        return new UnknownLinkException(context.getMessage("common.unknownLink"));
    }

    public BaseRuntimeException getOperateFailException(RequestContext context, Throwable e) {
        return new OperateFailException(context.getMessage("common.operateFail"), e);
    }

    public BaseRuntimeException getUnauthorizedException(RequestContext context) {
        return new UnauthorizedException(context.getMessage("common.unauthorized"));
    }

    public BaseRuntimeException getUnknownCategoryException(RequestContext context) {
        return new UnknownBlogCategoryException(context.getMessage("common.unknownCategory"));
    }

    public BaseRuntimeException getBloggerNotLoggedInException(RequestContext context) {
        return new BloggerNotLoggedInException(context.getMessage("blogger.notLoggedIn"));
    }

    public BaseRuntimeException getBlogIllegalException(RequestContext context) {
        return new BlogContentIllegalException(context.getMessage("blog.illegal"));
    }

    public BaseRuntimeException getDuplicationDataException(RequestContext context) {
        return new DuplicationDataException(context.getMessage("common.duplicationData"));
    }

    public BaseRuntimeException getParameterFormatIllegalException(RequestContext context) {
        return new ParameterFormatIllegalException(context.getMessage("common.parameterFormatIllegal"));
    }

    public BaseRuntimeException getParameterTypeMismatchException(RequestContext context, Throwable e) {
        return new ParameterTypeMismatchException(context.getMessage("common.parameterTypeMismatch"), e);
    }

    public BaseRuntimeException getLoginFailException(RequestContext context, boolean passwordIncorrect) {
        return new LoginFailException(context.getMessage(passwordIncorrect ? "blogger.passwordIncorrect" : "blogger.unknownAccount"));
    }

    public BaseRuntimeException getPictureFormatErrorException(RequestContext context) {
        return new PictureFormatErrorException(context.getMessage("common.pictureFormatError"));
    }
}
