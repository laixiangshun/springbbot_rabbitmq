package com.rabbitmq.controller;

import com.rabbitmq.callback.CallBackSender;
import com.rabbitmq.fanout.FanoutSender;
import com.rabbitmq.hello.HelloSender1;
import com.rabbitmq.hello.HelloSender2;
import com.rabbitmq.topic.TopicSender;
import com.rabbitmq.user.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lailai on 2017/12/9.
 */
@Controller
@RequestMapping("/rabbit")
public class RabbitTest {
    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender2 helloSender2;

    @Autowired
    private UserSender userSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private CallBackSender callBackSender;

    /**
     * 单生产者-单消费者
     */
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public void hello(){
        helloSender1.send("hello1");
    }

    /**
     * 单生产者-多消费者
     */
    @RequestMapping(value = "/oneToMany",method = RequestMethod.POST)
    public void oneToMany(){
        for (int i=0;i<10;i++){
            helloSender1.send("helloMsg:"+i);
        }
    }

    /**
     * 多生产者-多消费者
     */
    @RequestMapping(value = "/manyToMany",method = RequestMethod.POST)
    public void manyToMany(){
        for (int i=0;i<10;i++){
            helloSender1.send("helloMsg:"+i);
            helloSender2.send("helloMsg:"+i);
        }
    }

    /**
     * 传输实体对象
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public void userTest(){
        userSender.send();
    }

    /**
     * topic Exchange
     */
    @RequestMapping(value = "/topic",method = RequestMethod.POST)
    public void topicTest(){
        topicSender.send();
    }

    /**
     * fanout Exchange
     */
    @RequestMapping(value = "/fanout",method = RequestMethod.POST)
    public void fanoutTest(){
        fanoutSender.send();
    }

    /**
     * 带callback的消息发送
     */
    @RequestMapping(value = "/callback",method = RequestMethod.POST)
    public void callback(){
        for (int i=0;i<5;i++){
            callBackSender.send("nononono"+i);
        }
    }

}
