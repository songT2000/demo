package com.demo.portal.test.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/** * @ClassName EchoServerHandler * @Description TODO * @Author MySelf * @Date 2019/8/17 18:14 * @Version 1.0 **/
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("服务器回复的消息：" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("EchoServerHandler 的Thread:" + Thread.currentThread().getName());

        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~2", CharsetUtil.UTF_8));
                    System.out.println("ChannelHandlerContext.channel().eventLoop().execute 的Thread:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("发生异常:" + e.getMessage());
                }
            }
        });
        System.out.println("非阻塞");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

