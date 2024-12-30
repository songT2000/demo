package com.demo.portal.listener;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis消息订阅者
 */
@Component
public class Subscriber implements MessageListener {

    @Autowired
    public RedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        //todo 消息处理 日志记录 邮件 积分
        //message 封装了消息管道和内容
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();
        Object bodyInfo = redisTemplate.getValueSerializer().deserialize(body);
        Object channelInfo = redisTemplate.getKeySerializer().deserialize(channel);
        System.out.println("消息接受成功:" + bodyInfo + " 通道：" + channelInfo);
    }
}
