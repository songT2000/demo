package com.demo.portal.test.zerocopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {

    public static void main(String[] args) throws IOException {
        //打开一个SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 7001));

        //得到一个文件channel
        File file = new File("D:\\software\\HTMLtoexe1_jb51.rar");
        FileChannel fileChannel = new FileInputStream(file).getChannel();
        //准备发送
        long startTime = System.currentTimeMillis();
        //在Linux下, 一个transferTo方法可以完成传输
        //在windows下，一次transferTo只能发送8M 就需要分段传输文件，
        //transferTo 底层用到零拷贝
        long transferCountTotal = 0;
        System.out.println("文件size: " + fileChannel.size());
        long fileSize = fileChannel.size();
        long temp = 8 * 1000 * 1000;
        while(true){
            if(transferCountTotal >= fileSize){
                break;
            }
            long transferCount = fileChannel.transferTo(transferCountTotal, temp, socketChannel);
            System.out.println("transferCount: " + transferCount);
            transferCountTotal+=transferCount;
        }

        System.out.println("发送的总字节数:" + transferCountTotal + "总耗时：" + (System.currentTimeMillis() - startTime));

        fileChannel.close();
    }
}
