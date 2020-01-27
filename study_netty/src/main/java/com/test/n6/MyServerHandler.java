package com.test.n6;

import com.test.pb1.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyServerHandler extends SimpleChannelInboundHandler<DataInfo.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataInfo.Student student) throws Exception {
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getAddress());
    }
}
