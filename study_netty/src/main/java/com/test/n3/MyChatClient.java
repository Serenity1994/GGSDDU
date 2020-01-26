package com.test.n3;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.*;

public class MyChatClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap
                    .group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new MyChatClientInitializer());
            Channel channel = bootstrap.connect("localhost", 8899).sync().channel();
            InputStream in;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            for(;;){
                channel.writeAndFlush(bufferedReader.readLine() + "\r\n");
            }
            //channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
