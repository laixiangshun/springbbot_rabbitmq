package com.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;

/**
 * Created by lailai on 2017/12/9.
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {
    @RabbitHandler
    public void process(String msg){
        System.out.println("FanoutReceiverA : "+msg);
    }
}
