package com.demo.service.impl.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Service;

@Service
public class RedisListenerManager {

    @Autowired
    public RedisMessageListenerContainer container;//redis消息监听者容器


    /**
     * 添加监听者
     */
    public void addListener(String topicName, MessageListenerAdapter messageListenerAdapter){
        container.addMessageListener(messageListenerAdapter, new ChannelTopic(topicName));
        System.out.println("Subscribed to channel: " + topicName);
    }

    /**
     * 删除监听者
     */
    public void removeListener(String topicName, MessageListenerAdapter messageListenerAdapter){
        container.removeMessageListener(messageListenerAdapter, new ChannelTopic(topicName));
        System.out.println("Unsubscribed to channel: " + topicName);
    }

}
