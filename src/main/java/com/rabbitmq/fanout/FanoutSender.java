package com.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2017/12/9.
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String msg="fanoutSender : fanout===============";
        System.out.println(msg);
        this.amqpTemplate.convertAndSend("fanoutExchange","abcd",msg);
    }
}
