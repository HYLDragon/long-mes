package com.zx.mes.hyl.test.rabbitmq.consumer.example;

import com.zx.mes.hyl.rabbitmq.consumer.HelloWorldRecv;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Administrator on 2017/10/18.
 */
public class HellowRec {

    @Test
    public void test(){
        HelloWorldRecv helloWorldRecv=new HelloWorldRecv();
        try {
            try {
                helloWorldRecv.receive();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
