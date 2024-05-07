package com.demo.portal.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * NIO 客服端测试
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //提供服务器端的ip和端口
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8006);
        //连接服务器
        //如果连接成功，就发送数据
        if(!socketChannel.connect(address)){
            while(!socketChannel.finishConnect()){
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其他工作..");
            }
        }
        String message = "Hello, world!";
        ByteBuffer byteBuffer = ByteBuffer.wrap(message.getBytes());//将字节数组包装到缓冲区中。
        //发送数据 将buffer的数据写入 channel
        socketChannel.write(byteBuffer);
        System.in.read();

    }
}
