package com.demo.portal.test.protocoltcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MyMessageDecoder extends ReplayingDecoder<Void> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder 的 decode方法执行");
        int len = in.readInt();
        byte[] bytes = new byte[len];
        in.readBytes(bytes);
        //封装成 MessageProtocol 对象并放入out, 传递给下一个Handler做业务处理
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(len);
        messageProtocol.setContent(bytes);
        out.add(messageProtocol);

    }
}
