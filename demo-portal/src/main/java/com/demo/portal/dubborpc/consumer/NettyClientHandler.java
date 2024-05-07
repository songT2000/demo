package com.demo.portal.dubborpc.consumer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {

    private ChannelHandlerContext channelHandlerContext;//上下文

    private String result;//返回的结果

    private String para;//客户端调用方法时传入的参数


    //与服务器的连接创建后就会被调用 1
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive 客户端和服务器端通道开启");
        channelHandlerContext = ctx;
    }

    //收到服务器消息后，调用方法
    // synchronized 修饰同步的
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("channelRead 服务端返回消息");
        result = msg.toString();
        notify();// 唤醒等待的下城
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    // 被代理对象调用，发送数据给服务器，-> wait ->后等待被唤醒
    @Override
    public synchronized Object call() throws Exception {
        System.out.println("call1 代理对象执行任务1");
        channelHandlerContext.writeAndFlush(para);
        //进行wait
        wait();// 等待channelRead 方法获取到服务器的结果后，唤醒
        System.out.println("call2 代理对象执行任务2");
        return result;// 服务方返回的结果
    }

    // 第二个被调用
    void setPara(String para){
        System.out.println("setPara 代理对象设置参数");
        this.para = para;
    }
}
