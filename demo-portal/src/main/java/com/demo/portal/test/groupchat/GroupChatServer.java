package com.demo.portal.test.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class GroupChatServer {

    //定义相关属性
    private Selector selector;
    private ServerSocketChannel listenChannel;
    public static final int PORT = 6688;

    //构造器初始化
    public GroupChatServer() {
        try {
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            //绑定端口
            listenChannel.bind(new InetSocketAddress(PORT));
            //设置非阻塞
            listenChannel.configureBlocking(false);
            //将listenChannel 注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //监听
    public void listen() {
        try {
            while (true) {
                int count = selector.select();//查询该选择器内2秒内触发事件的通道 如果没有选择时间就会阻塞
                if (count > 0) {//选择器有事件触发
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        //监听accept 如果是注册消息
                        if (key.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            //将该sc注册到selector(选择器)
                            sc.register(selector, SelectionKey.OP_READ);
                            //提示注册成功
                            System.out.println(sc.getRemoteAddress() + " 上线");
                        }
                        //如果是可读消息
                        if (key.isReadable()) {
                            //处理读方法
                            this.readData(key);
                        }
                        //当前 的key删除，防止重复处理
                        iterator.remove();
                    }
                } else {
                    System.out.println("等待中。。。");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    //读取客户端消息
    private void readData(SelectionKey key) {
        //取到关联的通道channel
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();
            //创建buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int readCount = channel.read(byteBuffer);
            //根据readCount的值做处理
            if (readCount > 0) {
                //把缓存区的数据转成字符串
                String msg = new String(byteBuffer.array());
                //输出
                System.out.println("form 客户端:" + msg);
                //向其他客户端转发消息
                this.sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了。。");
                //取消注册
                key.channel();
                //关闭通道
                channel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    //转发消息给其他客户端
    private void sendInfoToOtherClients(String msg, SocketChannel channel) throws IOException {
        System.out.println("服务器转发消息。。");
        //遍历选择器selector注册的SocketChannel 注意排除自己
        Set<SelectionKey> keys = selector.keys();
        for (SelectionKey key : keys) {
            //通过key 取出对应的SocketChannel
            Channel targetChannel = key.channel();
            //排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != channel) {
                //转型
                SocketChannel dest = (SocketChannel) targetChannel;
                //将msg存储到buffer
                ByteBuffer byteBuffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer的数据写入通道
                dest.write(byteBuffer);
            }
        }

    }


    public static void main(String[] args) {
        new GroupChatServer().listen();
    }
}
