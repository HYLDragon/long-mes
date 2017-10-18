package com.zx.mes.hyl.rabbitmq.provider;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/10/18.
 */
public class HelloWorld {
    private static final Logger logger=Logger.getLogger(HelloWorld.class);
    private static final String QUEUE_NAME="hello";

    public void send(Object object) throws IOException, TimeoutException {
        //创建 工厂连接
        ConnectionFactory factory=new ConnectionFactory();
    //设置rabbitmq服务器地址
        factory.setHost("10.30.90.68");
        //factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin123");
    //建立连接
        Connection connection=factory.newConnection();
   //创建通道
        Channel channel=connection.createChannel();
   //     创建队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
   //
        String message="hello world !";
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        logger.info(JSON.toJSONStringWithDateFormat("消息已发送!","yyyy-MM-dd HH:mm:ss"));
   //     关闭
        channel.close();
        connection.close();
   }
}