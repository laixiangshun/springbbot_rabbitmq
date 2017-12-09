package com.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2017/12/9.
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver1 {
    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver1:"+hello);
    }
}
