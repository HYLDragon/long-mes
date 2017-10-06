package com.zx.mes.hyl.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * 启动解压long-admin-x.x.x.jar到resources目录
 *
 * Created by hyl on 17/10/6.
 */
public class LongAdminUtil implements InitializingBean,ServletContextAware{

    private static final Logger logger=Logger.getLogger(LongAdminUtil.class);

    public void afterPropertiesSet() throws Exception {

    }

    public void setServletContext(ServletContext servletContext) {
        logger.info(JSON.toJSONStringWithDateFormat("===== 开始解压long-admin =====","yyyy-MM-dd HH:mm:ss"));
        String version=PropertiesFileUtil.getInstance().get("long-admin.version");
        logger.info(JSON.toJSONStringWithDateFormat("long-admin.jar 版本: "+version,"yyyy-MM-dd HH:mm:ss"));
        String jarPath=servletContext.getRealPath("/WEB-INF/lib/long-admin-" + version + ".jar");
        logger.info(JSON.toJSONStringWithDateFormat("long-admin.jar 包路径: "+jarPath,"yyyy-MM-dd HH:mm:ss"));
        String resources=servletContext.getRealPath("/") + "/resources/long-admin";
        logger.info(JSON.toJSONStringWithDateFormat("long-admin.jar 解压到: "+resources,"yyyy-MM-dd HH:mm:ss"));
        JarUtil.decompress(jarPath,resources);
        logger.info(JSON.toJSONStringWithDateFormat("===== 解压long-admin完成 =====","yyyy-MM-dd HH:mm:ss"));
    }
}
