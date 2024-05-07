package com.demo.portal.test.netty.inboundhardlerandoutboundhardler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    //编码方法
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Long aLong, ByteBuf byteBuf) throws Exception {
        System.out.println("MyLongToByteEncoder 的 encode 方法被调用");
        System.out.println("Msg:" +aLong);
        byteBuf.writeLong(aLong);
    }

}
