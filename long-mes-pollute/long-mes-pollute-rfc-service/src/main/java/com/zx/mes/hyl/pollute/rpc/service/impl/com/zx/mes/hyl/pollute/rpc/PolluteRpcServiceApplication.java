package com.zx.mes.hyl.pollute.rpc.service.impl.com.zx.mes.hyl.pollute.rpc;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/10/16.
 */
public class PolluteRpcServiceApplication {
    private static final Logger logger=Logger.getLogger(PolluteRpcServiceApplication.class );

    public static void main(String[] args){
        logger.info(JSON.toJSONStringWithDateFormat(">>>>> long-mes-pollute-rpc-service 正在启动 <<<<<","yyyy-MM-dd " +
                "HH:mm:ss"));
        //new ClassPathXmlApplicationContext("classpath:*.xml");
        new ClassPathXmlApplicationContext(new String[]{"classpath:*.xml","classpath:dubbo/*.xml"});
        logger.info(JSON.toJSONStringWithDateFormat(">>>>> long-mes-pollute-rpc-service 启动完成 <<<<<","yyyy-MM-dd " +
                "HH:mm:ss"));
    }
}
