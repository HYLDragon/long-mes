package com.zx.mes.hyl.test.rabbitmq.provider.example;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/10/18.
 */
public class HelloWorld {
    @Test
    public void test(){
        com.zx.mes.hyl.rabbitmq.provider.HelloWorld helloWorld=new com.zx.mes.hyl.rabbitmq.provider.HelloWorld();
        try {
            helloWorld.send(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
