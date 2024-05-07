package com.demo.portal.test.netty.echo2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @ClassName EchoServerHandler * @Description TODO * @Author MySelf * @Date 2019/8/17 18:14 * @Version 1.0
 **/
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    //group 就是充当业务线程池，可以将任务提交到该线程池
    // 这里我们创建16个线程
    static final EventExecutorGroup group = new DefaultEventExecutorGroup(16);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端发送消息：" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("EchoServerHandler 的Thread:" + Thread.currentThread().getName());
        // 使用eventLoop的 execute或者schedule 还是同一个线程
//        ctx.channel().eventLoop().schedule(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(20 * 1000);
//                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~4", CharsetUtil.UTF_8));
//                    System.out.println("ChannelHandlerContext.channel().eventLoop().execute 的Thread:" + Thread.currentThread().getName());
//                } catch (InterruptedException e) {
//                    System.out.println("发生异常:" + e.getMessage());
//                }
//            }
//        }, 5, TimeUnit.SECONDS);

        group.submit(() -> {
            //休眠 10秒
            Thread.sleep(10 * 1000);
            System.out.println("group.submit 的Thread:" + Thread.currentThread().getName());
            ctx.writeAndFlush(Unpooled.copiedBuffer("客户端你好", CharsetUtil.UTF_8));
            return null;
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

