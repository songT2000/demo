package com.demo.portal.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO服务器端
 */
public class NIOServer {
    public static void main(String[] args) throws Exception {
        System.out.println("NIO服务器端");
        //创建ServerSocketChannel 相当于 SocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到一个Selector对象
        Selector selector = Selector.open();
        //给ServerSocketChannel 绑定一个端口 在服务器上监听 并设置为非阻塞
        serverSocketChannel.socket().bind(new InetSocketAddress(8006));
        serverSocketChannel.configureBlocking(false);//非阻塞
        //把ServerSocketChannel 注册到Selector 注册事件为连接 OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //循环等待客户端连接
        while (true) {

            //这里我们等待1秒，如果没有事件发生，返回
            if (selector.select(1000) == 0) {//没有事件发生
                System.out.println("服务器等待了一秒，没有事件发生！");
                continue;
            }

            //如果返回的>0 就获取相关的selectKey集合
            //如果返回的>0 标识获取关注的事件
            //selector.selectedKeys(); 返回关注事件的集合
            // 通过selectionKeys 反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectionKeys 数量 = " + selectionKeys.size());
            //遍历 Set<SelectionKey> 使用迭代器
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                //获取到SelectionKey
                SelectionKey selectionKey = iterator.next();
                System.out.println(selectionKey.isValid());
                //手动从集合中移除当前的selectionKey,防止重复操作
                iterator.remove();
                //根据key对应的通道发生的事件做相应处理
                if (selectionKey.isAcceptable()) {// 如果是OP_ACCEPT,有新的客户端连接
                    //为该客户端生成一个SocketChannel
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    System.out.println("客户端连接成功，生成一个SocketChannel:" + socketChannel.hashCode());
                    //设置socketChannel 未非阻塞
                    socketChannel.configureBlocking(false);
                    //将 socketChannel 注册到selector 关注事件为OP_READ  同时给该SocketChannel 关联一个buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                } else if (selectionKey.isReadable()) {//如果发生 OP_READ
                    //通过key 反向获取到对应的channel
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //获取到该SocketChannel对应的Buffer
                    socketChannel.configureBlocking(false);
                    ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();//检索当前key的附件
                    try {
                        socketChannel.read(byteBuffer);
                    } catch (IOException e) {
//                        selectionKey.channel();
//                        socketChannel.socket().close();
//                        socketChannel.close();
//                        return;
                    }
                    System.out.println("from客户端：" + new String(byteBuffer.array()));
                } else {
                    System.out.println("不是连接和read");
                }
            }
        }
    }
}
