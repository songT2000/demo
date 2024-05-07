package com.demo.portal.test.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class NettyByteBuf02 {
    public static void main(String[] args) {
        //创建 ByteBuf
        ByteBuf byteBuf = Unpooled.copiedBuffer("你好，中国人！！", Charset.forName("UTF-8"));

        if (byteBuf.hasArray()) {
            byte[] array = byteBuf.array();
            System.out.println(new String(array, Charset.forName("UTF-8")));
            System.out.println("byteBuf:" + byteBuf);
            System.out.println(byteBuf.arrayOffset());
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.writerIndex());
            System.out.println(byteBuf.capacity());//byteBuf 容量
            System.out.println(byteBuf.readByte());//
            int len = byteBuf.readableBytes();//可读取字节数
            System.out.println("len = " + len);
            for (int i = len - 1; i >= len; i--) {
                System.out.println(byteBuf.getByte(i));//
            }
            for (int i = 0; i < len; i++) {
                System.out.println((char) byteBuf.getByte(i));//
            }


        }

    }

}
