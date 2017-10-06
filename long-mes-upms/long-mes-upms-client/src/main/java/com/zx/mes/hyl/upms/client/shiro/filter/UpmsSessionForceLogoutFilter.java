package com.zx.mes.hyl.upms.client.shiro.filter;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 强制退出会话过滤器
 * Created by shuzheng on 2017/3/1.
 */
public class UpmsSessionForceLogoutFilter extends AccessControlFilter {

    private static final Logger logger=Logger.getLogger(UpmsSessionForceLogoutFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Session session = getSubject(request, response).getSession(false);
        if(session == null) {
            return true;
        }
        boolean forceout = session.getAttribute("FORCE_LOGOUT") == null;
        logger.debug(JSON.toJSONStringWithDateFormat("强制退出会话","yyyy-MM-dd HH:mm:ss"));
        return  forceout;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        getSubject(request, response).logout();
        String loginUrl = getLoginUrl() + (getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1";
        WebUtils.issueRedirect(request, response, loginUrl);
        return false;
    }

}
