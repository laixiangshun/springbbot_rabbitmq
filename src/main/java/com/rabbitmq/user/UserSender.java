package com.rabbitmq.user;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2017/12/9.
 * 实体类的传输
 */
@Component
public class UserSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        User user=new User();
        user.setName("rainbow");
        user.setPass("123");
        System.out.println("user send : "+user.getName()+"/"+user.getPass());
        this.amqpTemplate.convertAndSend("user",user);
    }
}
