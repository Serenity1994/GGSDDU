package com.test.n11zorecopy;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        String fileName = "/Users/serenityma/Documents/[第 6 季.Ep16] 马男波杰克 - 好的时候很好.mp4";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        long startTime = System.currentTimeMillis();
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("transferCount:" + transferCount + ";耗时:" + (System.currentTimeMillis() - startTime));
        fileChannel.close();
        socketChannel.close();
    }
}
