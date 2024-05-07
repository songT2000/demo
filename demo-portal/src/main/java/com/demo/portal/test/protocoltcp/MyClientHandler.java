package com.demo.portal.test.protocoltcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol messageProtocol) throws Exception {
        int len = messageProtocol.getLen();
        byte[] content = messageProtocol.getContent();

        System.out.println("从服务器" + channelHandlerContext.channel().remoteAddress() + "接收到消息长度： " + len);
        System.out.println("从服务器" + channelHandlerContext.channel().remoteAddress() + "接收到消息内容： " + new String(content, CharsetUtil.UTF_8));
        System.out.println("客户端接收消息次数：" + (++this.count));
    }

    //重写 channelActive 发送数据
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(" MyClientHandler 发送数据");
        for (int i = 0; i < 5; i++) {
            String msg = "冬天第一场雪，一起去吃火锅";
            byte[] bytes = msg.getBytes(CharsetUtil.UTF_8);
            int len = bytes.length;
            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setLen(len);
            messageProtocol.setContent(bytes);
            ctx.writeAndFlush(messageProtocol);

        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
