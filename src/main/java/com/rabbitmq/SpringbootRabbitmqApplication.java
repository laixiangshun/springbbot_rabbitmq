package com.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootRabbitmqApplication {

	final static String queueName="hello";
	@Bean
	public Queue helloQueue(){
		return new Queue("hello");
	}
	@Bean
	public Queue userQueue(){
		return new Queue("user");
	}
	@Bean
	public Queue queueMessage(){
		return new Queue("topic.message");
	}
	@Bean
	public Queue queueMessages(){
		return new Queue("topic.messages");
	}

	@Bean
	public Queue AMessage(){
		return new Queue("fanout.A");
	}
	@Bean
	public Queue BMessage(){
		return new Queue("fanout.B");
	}
	@Bean
	public Queue CMessage(){
		return new Queue("fanout.C");
	}

	@Bean
	TopicExchange exchange(){
		return new TopicExchange("exchange");
	}
	@Bean
	FanoutExchange fanoutExchange(){
		return new FanoutExchange("fanoutExchange");
	}

	@Bean
	Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}
	@Bean
	Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange){
		return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//模糊匹配
	}
	@Bean
	Binding bindingExchangeA(Queue AMessage,FanoutExchange fanoutExchange){
		return BindingBuilder.bind(AMessage).to(fanoutExchange);
	}
	@Bean
	Binding bindingExchangeB(Queue BMessage,FanoutExchange fanoutExchange){
		return BindingBuilder.bind(BMessage).to(fanoutExchange);
	}
	@Bean
	Binding bindingExchangeC(Queue CMessage,FanoutExchange fanoutExchange){
		return BindingBuilder.bind(CMessage).to(fanoutExchange);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqApplication.class, args);
	}
}
