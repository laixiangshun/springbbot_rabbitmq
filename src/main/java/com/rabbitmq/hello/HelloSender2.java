package com.rabbitmq.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lailai on 2017/12/9.
 */
@Component
public class HelloSender2 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg){
        String sendMsg = msg + new Date();
        System.out.println("Sender2 : " + sendMsg);
        this.amqpTemplate.convertAndSend("hello", sendMsg);
    }
}
