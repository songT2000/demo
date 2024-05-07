package com.demo.portal.test.netty.groupchat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class GroupChatServerHandler extends SimpleChannelInboundHandler<String> {

    //定义一个channel组，管理所有的 channel
    //GlobalEventExecutor.INSTANCE 是全局的事件执行器，是一个单列
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 私聊 用户
    private static Map<User, Channel> channelMap = new HashMap<>();

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
    }

    //handlerAdded 在将ChannelHandler添加到实际的上下文并准备好处理事件之后被调用。 第一个被执行
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        //将该客户加入聊天（连接）的信息推送给其他在线（已连接）的客户端
        //该方法会将 channelGroup 中所有的channel 遍历，并发送消息。无需我们自己遍历
        channelGroup.writeAndFlush("【客户端】" + channel.remoteAddress() + "于" + dateTimeFormatter.format(LocalDateTime.now()) + " 加入聊天\n");
        channelGroup.add(channel);
    }

    // 断开连接 将XXX客户离开信息发送给在线客户端
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【客户端】" + channel.remoteAddress() + "于" + dateTimeFormatter.format(LocalDateTime.now()) + " 离开了\n");
        System.out.println("ChannelGroup size ：" + channelGroup.size());
    }

    // 当 channel 处于活动状态，提示XXX上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "上线了!");
    }

    // 当channel处于非活动状态，提示XXX下线
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "下线了!");
    }

    // 读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //获取当前的 channel
        Channel channel = ctx.channel();
        for (Channel ch : channelGroup) {
            if (channel != ch) {
                ch.writeAndFlush("【客户】" + channel.remoteAddress() + "于" + dateTimeFormatter.format(LocalDateTime.now()) + " 发送了消息：" + msg + "\n");
            } else {// 回显自己发送的消息给自己
                ch.writeAndFlush("【自己】发送了消息：" + msg + "\n");
            }
        }
    }

    // 异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 关闭通道
        ctx.close();
    }
}
