package com.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2017/12/9.
 */
@Component
@RabbitListener(queues = "topic.messages")
public class topicMessagesReceiver {
    @RabbitHandler
    public void process(String msg){
        System.out.println("topicMessagesReceiver : "+msg);
    }
}
