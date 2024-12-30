package com.demo.portal.controller;

import com.demo.common.domain.RestResponse;
import com.demo.portal.link.ApiUrl;
import com.demo.service.impl.manager.RedisListenerManager;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiUrl.PORTAL_USER)
public class PortalUserController {

    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public MessageListenerAdapter messageListenerAdapter;

    @Autowired
    public RedisListenerManager redisListenerManager;

    @RequestMapping(value = ApiUrl.TEST_REDIS, method = RequestMethod.GET)
    @ApiOperation("测试消息")
    public RestResponse<Object> testRedis(@RequestParam String topicName, @RequestParam String message){
        redisTemplate.convertAndSend(topicName, message);
        return null;
    }

    @RequestMapping(value = ApiUrl.TEST_ADD_LISTENER, method = RequestMethod.GET)
    @ApiOperation("测试添加订阅")
    public RestResponse<Object> testAddListener(@RequestParam String topicName){
        redisListenerManager.addListener(topicName, messageListenerAdapter);
        return null;
    }


    @RequestMapping(value = ApiUrl.TEST_REMOVE_LISTENER, method = RequestMethod.GET)
    @ApiOperation("测试取消订阅")
    public RestResponse<Object> testRemoveListener(@RequestParam String topicName){
        redisListenerManager.removeListener(topicName, messageListenerAdapter);
        return null;
    }




}
