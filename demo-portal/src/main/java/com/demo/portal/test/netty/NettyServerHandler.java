package com.demo.portal.test.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 说明
 * 1.我们自定义一个Handler 需要继续netty 规定好的某个HandlerAdapter（规范）
 * 2.这时我们自定义一个Handler，才能成为一个Handler
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    //读取数据事件（这里我们可以读取客户端发送的消息）
    /*
    1. ChannelHandlerContext ctx; 上下文对象，含有管道pipeline,通道channel,地址
    2. Object msg 客户端发送的数据 默认是Object
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //比如这里我们有一个耗时长的业务->异步执行 -> 提交改channel对应的
        //NIOEventLoop 的 taskQueue 中
        //解决方案一
        /*
        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~2", CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    System.out.println("发生异常:" + e.getMessage());
                }
            }
        });
        */
//        ctx.channel().eventLoop().execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(20 * 1000);
//                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~3", CharsetUtil.UTF_8));
//                } catch (InterruptedException e) {
//                    System.out.println("发生异常:" + e.getMessage());
//                }
//            }
//        });
//
//        //解决方案二
        //自定义定时任务 -》 该任务是提交到 scheduleTaskQueue
        /*
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(20 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~4", CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    System.out.println("发生异常:" + e.getMessage());
                }
            }
        }, 5, TimeUnit.SECONDS);

        */
//
//        //解决方案三
//        //非当前Reactor 线程调用 Channel 的各种方法
//
//        System.out.println("go on ....");
        System.out.println("服务器读取线程：" + Thread.currentThread().getName() + " channel = " + ctx.channel());
        System.out.println("serve ctx:" + ctx);
        //将 msg转成一个 Bytebuf
        //Bytebuf 是Netty提供的，不是NIO的 ByteBuffer;
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端发送消息：" + byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址：" + ctx.channel().remoteAddress());
    }

    //数据读取完毕后
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //writeAndFlush 是 write + flush
        //将数据写入到缓存，并刷新
        //一般讲。我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~1", CharsetUtil.UTF_8));
    }

    //处理异常 一般是关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
