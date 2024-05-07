package com.demo.portal.test.zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NewIOServer {

    public static void main(String[] args) throws IOException {
        //创建一个地址
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7001);
        //打开一个服务通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket socket = serverSocketChannel.socket();
        //服务通道绑定地址
        socket.bind(inetSocketAddress);
        //创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        //监听等待客户端连接
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();

            long readCount = 0;
            while (-1 != readCount) {
                try {
                    readCount = socketChannel.read(byteBuffer);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
                //ByteBuffer 需要倒带
                byteBuffer.rewind();
            }
        }
    }

}
