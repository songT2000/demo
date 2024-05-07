package com.demo.portal.test.netty.codec2;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * 说明
 * 1.我们自定义一个Handler 需要继续netty 规定好的某个HandlerAdapter（规范）
 * 2.这时我们自定义一个Handler，才能成为一个Handler
 */
//public class NettyServerHandler extends ChannelInboundHandlerAdapter {
public class NettyServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyDataInfo.MyMessage myMessage) throws Exception {
        //读取从客户端发送的 MyDataInfo.MyMessage
        if (myMessage.getDataType() == MyDataInfo.MyMessage.DataType.StudentType) {
            MyDataInfo.Student student = myMessage.getStudent();
            System.out.println("客户端发送的数据：" + student.getGrade() + " " + student.getClassGrade() + " " + student.getName());
        } else if (myMessage.getDataType() == MyDataInfo.MyMessage.DataType.SoldierType) {
            MyDataInfo.Soldier soldier = myMessage.getSoldier();
            System.out.println("客户端发送的数据：" + soldier.getArmService() + " " + soldier.getName());
        } else {
            System.out.println("发送类型错误！");
        }
    }

    //读取数据事件（这里我们可以读取客户端发送的消息）
    /*
    1. ChannelHandlerContext ctx; 上下文对象，含有管道pipeline,通道channel,地址
    2. Object msg 客户端发送的数据 默认是Object
     */
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        //读取从客户端发送的 StudentPOJO.Student
//        StudentPOJO.Student student = (StudentPOJO.Student) msg;
//        System.out.println("客户端发送的数据：" + student.getGrade() + " " + student.getClassGrade() + " " + student.getName());
//    }

    //数据读取完毕后
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //writeAndFlush 是 write + flush
        //将数据写入到缓存，并刷新
        //一般讲。我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, 客户端~1", CharsetUtil.UTF_8));
    }

    //处理异常 一般是关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

}
