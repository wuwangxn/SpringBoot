package com.xning.demo.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Environment env;

    @RequestMapping(value = "/test")
    public void test(String value){
        rabbitTemplate.setExchange(env.getProperty("test.exchange.name"));
        rabbitTemplate.setRoutingKey(env.getProperty("test.routing.key.name"));
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        Message message = MessageBuilder.withBody(value.getBytes()).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        message.getMessageProperties().setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, MessageProperties.CONTENT_TYPE_JSON);
        rabbitTemplate.convertAndSend(message);
    }
}
