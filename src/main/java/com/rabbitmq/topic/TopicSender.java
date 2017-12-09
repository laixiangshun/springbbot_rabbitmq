package com.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2017/12/9.
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg1="I am topic.message msg=============";
        System.out.println("sender1 : " + msg1);
        this.amqpTemplate.convertAndSend("exchange", "topic.message", msg1);

        String msg2="I am topic.messages msg##############";
        System.out.println("sender2 : "+msg2);
        this.amqpTemplate.convertAndSend("exchange","topic.messages",msg2);
    }
}
