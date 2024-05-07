package com.demo.portal.test.netty.codec;

import com.demo.portal.test.netty.codec.proto.StudentPOJO;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * Netty本身的编解码的机制和问题分析
 * 1. Netty提供的额编码器
 *  StringEncoder 对字符串数据进行编码
 *  ObjectEncoder 对java对象进行编码
 * 2. Netty对应提供的解码器
 *  StringDecoder
 *  ObjectDecoder
 * 3. Netty本身自带的Object编解码器可以用来实现POJO對象或各种业务对象的编解码，
 *  底层使用的仍然是java序列化技术，而java序列化技术本身效率就不高，有如下问题：
 *  a.无法跨语言
 *  b.序列化后的体积太大，是二进制编码的5倍多。
 *  c.序列化性能太低。
 *  于是就有新的解决方案，Google的Protobuf
 * 4. Protobuf基本介绍
 *  a. Protobuf是Google发布的开元项目，全称 Google protocol Buffers 是一种
 *   轻便高效的结构化数据存储格式。可以用于结构化数据串行化，或者说序列化。它很适合做
 *   数据存储或者 RPC【远程过程调用 remote procedurecall】 数据交换格式，
 *
 *  protobuf使用流程：
 *   a.导入pom.xml文件(导入版本最好和 protobuf编译工具 版本相同)
 *   b.创建 XXX.proto 文件
 *   c.编辑工具编译成java文件  命令：protoc.exe --java_out=. XXX.proto
 *   d.Netty提供编解码器 ProtobufDecoder ProtobufEncoder
 */
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
                            ChannelPipeline pipeline = ch.pipeline();
                            //在pipeline中加入ProtobufDecoder 需要指定对那种对象解码
                            pipeline.addLast("decoder", new ProtobufDecoder(StudentPOJO.Student.getDefaultInstance()));
                            pipeline.addLast(new NettyServerHandler());
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
