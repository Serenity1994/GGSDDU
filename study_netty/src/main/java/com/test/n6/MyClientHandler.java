package com.test.n6;

import com.test.pb1.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyClientHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataInfo.Student student) throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("mike").setAge(20).setAddress("hangzhou").build();
        ctx.channel().writeAndFlush(student);
    }
}
