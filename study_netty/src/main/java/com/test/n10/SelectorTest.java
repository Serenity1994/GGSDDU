package com.test.n10;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        for (int i = 0; i < 5; i++) {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            InetSocketAddress socketAddress = new InetSocketAddress(5000 + i);
            serverSocket.bind(socketAddress);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("监听端口:" + 5000 + i);
        }
        while (true) {
            System.out.println("before selector.select()");
            int select = selector.select();
            System.out.println("after selector.select()");
            System.out.println("selector.select()返回值:" + select);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                System.out.println(selectionKey+"---------");
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("客户端连接:" + socketChannel);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                    while (socketChannel.read(byteBuffer) > 0) {
                        System.out.println("读取数据:" + byteBuffer.toString());
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        byteBuffer.flip();
                    }
                }
                // kernel
                // 为啥要移除:因为selector不会自己删除selectionKeys()方法中的SelectionKey,
                // 如果不手动移除的话,下次select()时selectionKeys中就会有上次轮询的结果.
                iterator.remove();
            }
        }
    }
}
