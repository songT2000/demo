package com.demo.portal.test.tcp;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        //拿到 pipeline
        ChannelPipeline pipeline = socketChannel.pipeline();
        //加入一个自定义的Handler ，处理业务
        pipeline.addLast(new MyClientHandler());

    }
}
