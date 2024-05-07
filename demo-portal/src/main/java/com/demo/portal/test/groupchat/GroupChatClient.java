package com.demo.portal.test.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class GroupChatClient {

    //定义相关的属性
    private final String HOST = "127.0.0.1";
    private final int POST = 6688;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    //构造器，完成初始化工作
    public GroupChatClient() throws IOException {
        selector = Selector.open();
        //连接到服务器
        socketChannel = socketChannel.open(new InetSocketAddress(HOST, POST));
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //将channel 注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        //得到username
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username + " is ok ");
    }

    //向服务器发送消息
    public void sendInfo(String info) {
        info = username + " 说：" + info;

        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取从服务器端回复的消息
    public void readInfo() {
        try {
            int readChannels = selector.select();//选择器中有可以用的通道
            if (readChannels > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        //得到相关通道
                        SocketChannel channel = (SocketChannel) key.channel();
                        //得到一个buffer
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        //读取
                        channel.read(byteBuffer);
                        //把读到的缓存区的数据转成字符串
                        String msg = new String(byteBuffer.array());
                        System.out.println(msg.trim());
                        iterator.remove();
                    }
                }
            } else {
                System.out.println("没有可用的通道...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        //启动我们的客户端
        GroupChatClient chatClient = new GroupChatClient();
        //启动一个线程 每隔3秒，读取从服务器发送数据
        new Thread() {
            public void run() {
                while (true) {
                    chatClient.readInfo();
                    try {
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        //发送数据给服务器端
        //控制台输入
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            chatClient.sendInfo(msg);
        }
    }


}
