package com.demo.portal.test.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class GroupChatServerM {

    //端口号
    public static final Integer PORT = 6688;
    //地址
    public static final String URL = "127.0.0.1";
    //ServerSocketChannel
    private ServerSocketChannel serverSocketChannel;
    //选择器
    private Selector selector;

    public GroupChatServerM() {
        //选择器
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(URL, PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GroupChatServerM().listen();
    }

    //监听
    private void listen() {
        try {
            while (true) {
                int count = selector.select();
                if (count > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    if (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        //连接
                        if (selectionKey.isValid() && selectionKey.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            socketChannel.getLocalAddress();
                            System.out.println(socketChannel.getRemoteAddress() + " 上线了...");
                        }
                        //读数据 并分发给其他人
                        if (selectionKey.isValid() && selectionKey.isReadable()) {
                            //处理读方法
                            this.readData(selectionKey);
                        }
                        iterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readData(SelectionKey selectionKey) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int readCount = socketChannel.read(buffer);
            if (readCount > 0) {
                String msg = new String(buffer.array()).trim();
                System.out.println(socketChannel.getRemoteAddress() + "说:" + msg);
                this.sendMsgToOther(msg, socketChannel);
            }
        } catch (IOException e) {
            try {
                System.out.println(socketChannel.getRemoteAddress() + " 离线了。。");
                //取消注册
                selectionKey.channel();
                //关闭通道
                socketChannel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }

    }

    private void sendMsgToOther(String msg, SocketChannel socketChannel) throws IOException {
        System.out.println("服务器转发消息。。");
        //所有注册过得通道，排除自己
        Set<SelectionKey> keys = selector.keys();//返回选择器中注册的selectionKey
        if (!keys.isEmpty()) {
            for (SelectionKey selectionKey : keys) {
                Channel channel = selectionKey.channel();
                if (channel instanceof SocketChannel && channel != socketChannel) {
                    SocketChannel dest = (SocketChannel) channel;
                    ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                    dest.write(byteBuffer);
                }
            }
        }

    }


}
