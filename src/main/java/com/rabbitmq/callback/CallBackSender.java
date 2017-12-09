package com.rabbitmq.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by lailai on 2017/12/9.
 */
@Component
public class CallBackSender implements RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void send(String msgs){
        rabbitTemplate.setConfirmCallback(this);
        String msg="callbackSender : +++++++++++++++++++++++++"+msgs;
        System.out.println(msg);
        CorrelationData correlationData=new CorrelationData(UUID.randomUUID().toString());
        System.out.println("callbackSender UUID : "+correlationData.getId());
        this.rabbitTemplate.convertAndSend("exchange","topic.messages",msg,correlationData);
    }
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        if(ack){
            System.out.println("callback confirm: ========"+correlationData.getId());
        }
    }
}
