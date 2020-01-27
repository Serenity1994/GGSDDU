package com.test.n7;

import com.test.pb1.N7Test;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyServerHandler extends SimpleChannelInboundHandler<N7Test.Msg> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, N7Test.Msg msg) throws Exception {
        N7Test.Msg.MsgType msgType = msg.getMsgType();
        if (msgType == N7Test.Msg.MsgType.Person) {
            System.out.println(msg.getPerson().getName());
        } else if (msgType == N7Test.Msg.MsgType.Dog) {
            System.out.println(msg.getDog().getName());
        } else {
            System.out.println(msg.getCat().getName());
        }
    }
}
