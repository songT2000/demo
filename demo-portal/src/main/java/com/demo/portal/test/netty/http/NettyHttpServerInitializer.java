package com.demo.portal.test.netty.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class NettyHttpServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //想管道加入处理器
        //得到管道
        ChannelPipeline pipeline = ch.pipeline();

        //加入一个Netty 提供的httpServerCodec codec => [coder - decoder] 编解码器
        //HttpServerCodec 说明
        //1.HttpServerCodec 是 netty提供的处理http的编解码器
        pipeline.addLast("MyHttpServerCodec", new HttpServerCodec());
        //2.增加一个自定义的handler
        pipeline.addLast("MyNettyHttpServerHandler", new NettyHttpServerHandler());

        System.out.println("ok!~~~~");

    }
}
