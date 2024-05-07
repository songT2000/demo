package com.demo.portal.test.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.UUID;


public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol) throws Exception {
        //服务端接受到信息并处理
        int len = messageProtocol.getLen();
        byte[] content = messageProtocol.getContent();

        System.out.println("服务器接收到" + channelHandlerContext.channel().remoteAddress() + "发送" + "消息长度：" + len);
        System.out.println("服务器接收到" + channelHandlerContext.channel().remoteAddress() + "发送" + "消息内容："
                + new String(content, CharsetUtil.UTF_8));
        System.out.println("服务器接收到消息包数量：" + (++this.count));

        //回送消息
        String responseContent = UUID.randomUUID().toString();
        int length = responseContent.getBytes(CharsetUtil.UTF_8).length;
        byte[] bytes = responseContent.getBytes(CharsetUtil.UTF_8);
        //构建一个协议包
        MessageProtocol messageProtocol1 =  new MessageProtocol();
        messageProtocol1.setLen(length);
        messageProtocol1.setContent(bytes);
        channelHandlerContext.writeAndFlush(messageProtocol1);
    }
}
