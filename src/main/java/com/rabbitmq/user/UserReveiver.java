package com.rabbitmq.user;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2017/12/9.
 */
@Component
@RabbitListener(queues = "user")
public class UserReveiver {
    @RabbitHandler
    public void process(User user){
        System.out.println("user receiver : "+user.getName()+"/"+user.getPass());
    }
}
