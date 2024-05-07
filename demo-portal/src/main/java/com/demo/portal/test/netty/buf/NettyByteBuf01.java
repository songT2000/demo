package com.demo.portal.test.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NettyByteBuf01 {
    public static void main(String[] args) {

        //创建一个ByteBuf
        //说明
        //1. 创建对象，该对象包含一个数组 arr, 是一个byte[10]
        //2. 在netty 的buffer中，不需要使用 flip(翻转) 进行翻转。因为底层维护了 readerIndex 和 writerIndex
        //3. 通过 readerIndex， writerIndex 和 capacity， 将 buffer分成三个区域
        //0 -- readerIndex 已经读取的区域
        //readerIndex -- writerIndex， 可读取的区域
        //writerIndex -- capacity 可写的区域
        ByteBuf byteBuf = Unpooled.buffer(10);
        System.out.println("capacity = " + byteBuf.capacity());
        for (int i = 0; i < 10; i++) {
            byteBuf.writeByte(i);
        }
        System.out.println("capacity = " + byteBuf.capacity());
        for (int i = 0; i < byteBuf.capacity(); i++) {
            System.out.println(byteBuf.getByte(i));
            System.out.println( byteBuf.readByte());
        }
        System.out.println("capacity = " + byteBuf.capacity());

    }

}
