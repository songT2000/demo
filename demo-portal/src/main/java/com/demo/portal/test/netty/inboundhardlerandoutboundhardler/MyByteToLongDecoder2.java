package com.demo.portal.test.netty.inboundhardlerandoutboundhardler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        System.out.println(" MyByteToLongDecoder2 的 decode方法被调用");
        //ReplayingDecoder 不需要判断数据是否足够读取，内部实现处理
        list.add(byteBuf.readLong());
    }
}
