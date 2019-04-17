package com.xning.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xning.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(value = "set")
    public void set(String key,String value){
        log.info("存入内容 key:{}  value:{}",key,value);
        stringRedisTemplate.opsForValue().set(key,value,10, TimeUnit.MINUTES);
    }

    @RequestMapping(value = "get")
    public void get(String key){
        log.info("获取内容  key:{}  value:{}",key,stringRedisTemplate.opsForValue().get(key));
    }

    @RequestMapping(value = "setOBJ")
    public void setOBJ(String key, User user) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(user);
        log.info("存入内容 key:{}  value:{}",key,json);
        stringRedisTemplate.opsForValue().set(key,json,10, TimeUnit.MINUTES);
    }

    @RequestMapping(value = "getOBJ")
    public void getOBJ(String key){
        log.info("获取内容  key:{}  value:{}",key,stringRedisTemplate.opsForValue().get(key));
    }
}
