package com.demo.portal.dubborpc.netty;

import com.demo.portal.dubborpc.provider.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.commons.lang3.StringUtils;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //获取客户端发送的消息，并调用活动
        System.out.println("msg= " + msg);
        //客户端在调用服务器的api时，我们需要约定一个协议
        //比如我们约定每次的消息内容都必须以某个字符串开头 HelloService#hello#你好
        if(StringUtils.startsWith(msg.toString(), "HelloService#hello#")){
            String result = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
