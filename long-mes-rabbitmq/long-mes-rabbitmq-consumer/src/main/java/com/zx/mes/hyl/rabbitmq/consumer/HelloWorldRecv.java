package com.zx.mes.hyl.rabbitmq.consumer;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/10/18.
 */
public class HelloWorldRecv {
    private static final Logger logger=Logger.getLogger(HelloWorldRecv.class);
    private static final String QUEUE_NAME="hello";

    public void receive() throws IOException, TimeoutException, InterruptedException {
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
        logger.debug(JSON.toJSONStringWithDateFormat("创建队列","yyyy-MM-dd HH:mm:ss"));
   //     创建队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

   //
        logger.debug(JSON.toJSONStringWithDateFormat("等待消息","yyyy-MM-dd HH:mm:ss"));

   //     消费
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message=new String(body,"utf-8");
                logger.info(JSON.toJSONStringWithDateFormat("接收的消息:"+message,"yyyy-MM-dd HH:mm:ss"));
            }
        };
        logger.info(JSON.toJSONStringWithDateFormat("接收消息完成:","yyyy-MM-dd HH:mm:ss"));
        channel.basicConsume(QUEUE_NAME, true,consumer);
        Thread.sleep(1000);
   }
}