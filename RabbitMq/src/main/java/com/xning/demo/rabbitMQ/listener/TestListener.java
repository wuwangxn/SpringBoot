package com.xning.demo.rabbitMQ.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RabbitListener(queues = "${test.queue.name}", containerFactory = "singleListenerContainer")
    public void userListener(@Payload byte[] message) {
        try {
            log.info("异步接收到消息:{}", new String(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
