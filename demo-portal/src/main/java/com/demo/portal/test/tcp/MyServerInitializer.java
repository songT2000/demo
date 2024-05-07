package com.demo.portal.test.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //拿到 pipeline
        ChannelPipeline pipeline = socketChannel.pipeline();
        //自定义handler
        pipeline.addLast(new MyServerHandler());
        System.out.println("MyServerInitializer 初始化完毕");
    }
}
