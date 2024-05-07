package com.demo.portal.test.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
        //创建BossGroup 和WorkerGroup
        //说明
        //1.创建两个线程组 bossGroup和 workerGroup
        //2. bossGroup 只是处理连接请求，真正的和客户端业务处理会交给workerGroup完成
        //3. 两个都是无限循环
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建服务器端的启动对象，并配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
            //使用链式编程来进行设置
            bootstrap.group(bossGroup, workerGroup)//设置两个线程组
                    .channel(NioServerSocketChannel.class)//使用NioServerSocketChannel 作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列得到的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持活动连接状态
//                    .handler(null) // 该handler对应的是 boosGroup 而childHandler对应的是 workerGroup
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建一个通道初始对象（匿名对象）

                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //可以使用一个集合管理 SocketChannel, 在推送消息时，可以将业务加入到各个channel 对应的NIOEventLoop 的
                            //taskQueue 或者 scheduleTaskQueue
                            System.out.println("客户SocketChannel hashcode = " + ch.hashCode());
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });// 给我们的workerGroup 的EventLoop 对应的管道设置处理器
            System.out.println("......服务器 is ready ...");

            //绑定一个端口并且同步，生成了一个 ChannelFuture对象
            //启动服务器（并绑定端口）
            ChannelFuture cf = bootstrap.bind(7008).sync();
            //Future-Listener 机制 （异步监听机制）
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        System.out.println("服务器启动成功！");
                    } else {
                        System.out.println("服务器启动失败！");
                    }
                }
            });


            //对关闭通道进行监听
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
