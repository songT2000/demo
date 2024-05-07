package com.demo.portal.dubborpc.consumer;

import com.demo.portal.dubborpc.publicinterface.HelloService;

public class ClientBootstrap {

    // 这里定义协议头
    public static final String providerName = "HelloService#hello#";

    public static void main(String[] args) throws Exception {

        //创建一个消费者
        NettyClient customer = new NettyClient();
        //创建代理对象
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);

        for (; ; ) {
            Thread.sleep(5 * 1000);
            //通多代理对象调用服务提供者的方法
            String res = service.hello("你好啊 dubbo~");
            System.out.println("调用结果 res = " + res);
        }
    }

}
