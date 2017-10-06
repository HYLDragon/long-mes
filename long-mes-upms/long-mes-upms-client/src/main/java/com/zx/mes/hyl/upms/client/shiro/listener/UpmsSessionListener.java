package com.zx.mes.hyl.upms.client.shiro.listener;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * on 2017/2/12.
 */
public class UpmsSessionListener implements SessionListener {

    private static final org.apache.log4j.Logger logger= org.apache.log4j.Logger.getLogger(UpmsSessionListener.class);


    public void onStart(Session session) {
        logger.debug(JSON.toJSONStringWithDateFormat("会话创建：" + session.getId(),"yyyy-MM-dd HH:mm:ss"));
    }


    public void onStop(Session session) {
        logger.debug(JSON.toJSONStringWithDateFormat("会话停止：" + session.getId(),"yyyy-MM-dd HH:mm:ss"));
    }


    public void onExpiration(Session session) {
        logger.debug(JSON.toJSONStringWithDateFormat("会话过期：" + session.getId(),"yyyy-MM-dd HH:mm:ss"));
    }

}
