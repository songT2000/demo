package com.demo.portal.test.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;


/*
说明：
1.SimpleChannelInboundHandler 是ChannelInboundHandlerAdapter 一个子类
2.HttpObject 客户端和服务端相互通讯的数据被封装成 HttpObject
 */
public class NettyHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {

    //当有读取客户端数据是触发
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        //判断 msg 是不是 httprequest请求
        if (msg instanceof HttpRequest) {
            System.out.println("ctx的类型：" + ctx.getClass());
            System.out.println("msg类型=" + msg.getClass());
            System.out.println("客户端地址=" + ctx.channel().remoteAddress());

            HttpRequest request = (HttpRequest) msg;
            URI uri = new URI(request.uri());
            if("/favicon.ico".equals(uri.getPath())){
                System.out.println("请求了 favicon.ico 不做处理！！");
                return;
            }
            //回复信息给浏览器 【http协议】
            ByteBuf byteBuf =  Unpooled.copiedBuffer("hello, 我是服务端~~", CharsetUtil.UTF_8);

            //构造一个http的响应，即HttpResponse
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, byteBuf.readableBytes());

            //将构建好的返回 response 返回
            ctx.writeAndFlush(response);
        }


    }
}
