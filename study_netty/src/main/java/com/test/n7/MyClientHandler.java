package com.test.n7;

import com.test.pb1.N7Test;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class MyClientHandler extends SimpleChannelInboundHandler<N7Test.Msg> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, N7Test.Msg student) throws Exception {
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int num = new Random().nextInt(3);
        N7Test.Msg msg = null;
        if (num == 0) {
            N7Test.Person person = N7Test.Person.newBuilder().setName("person").build();
            msg = N7Test.Msg.newBuilder().setMsgType(N7Test.Msg.MsgType.Person).setPerson(person).build();
        } else if (num == 1) {
            N7Test.Dog dog = N7Test.Dog.newBuilder().setName("dog").build();
            msg = N7Test.Msg.newBuilder().setMsgType(N7Test.Msg.MsgType.Dog).setDog(dog).build();
        } else {
            N7Test.Cat cat = N7Test.Cat.newBuilder().setName("cat").build();
            msg = N7Test.Msg.newBuilder().setMsgType(N7Test.Msg.MsgType.Cat).setCat(cat).build();
        }
        ctx.channel().writeAndFlush(msg);
    }
}
