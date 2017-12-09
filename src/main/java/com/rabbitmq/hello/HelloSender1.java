package com.rabbitmq.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lailai on 2017/12/9.
 * 单生产者和单消费者
 */
@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg){
        String sendMsg=msg +(new Date()).getTime();
        System.out.println("Sender1 :"+sendMsg);
        this.amqpTemplate.convertAndSend("hello",sendMsg);
    }
}
