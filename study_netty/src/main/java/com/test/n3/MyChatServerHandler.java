package com.test.n3;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        Channel channel = channelHandlerContext.channel();
        System.out.println("[" + channel.remoteAddress() + "]:" + s);
        channelGroup.forEach(ch -> {
            if (ch != channel) {
                ch.writeAndFlush("[" + ch.remoteAddress() + "]发送消息:" + s +"\n");
            } else {
                ch.writeAndFlush("[自己]发送消息:" + s +"\n");
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        channelGroup.forEach(ch -> {
            ch.writeAndFlush("[系统]:" + ctx.channel().remoteAddress() + "上线" +"\n");
        });
        channelGroup.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channelGroup.remove(ctx.channel());
        channelGroup.forEach(ch -> {
            ch.writeAndFlush("[系统]:" + ctx.channel().remoteAddress() + "下线" +"\n");
        });
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "上线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "下线");
    }
}
