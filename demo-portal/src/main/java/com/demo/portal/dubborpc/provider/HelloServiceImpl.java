package com.demo.portal.dubborpc.provider;

import com.demo.portal.dubborpc.publicinterface.HelloService;
import org.apache.commons.lang3.StringUtils;

public class HelloServiceImpl implements HelloService {

    private static int count;

    @Override
    public String hello(String msg) {
        System.out.println("收到客户端信息：" + msg);
        //根据msg 返回不同的结果
        if (StringUtils.isNotBlank(msg)) {
            return "你好客户端，我已经收到你的消息：" + msg + " 消息计数:" + (++count);
        } else {
            return "你好客户端，我已经收到你的消息。" + " 消息计数:" + (++count);
        }
    }
}
