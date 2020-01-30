package com.test.n9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
 * 使用NIO读取文件并写入到另一个文件
 */
public class NioTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/serenityma/IdeaProjects/GGSDDU/study_netty/src/main/java/com/test/n9/from.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/serenityma/IdeaProjects/GGSDDU/study_netty/src/main/java/com/test/n9/to.txt");
        FileChannel fileInputChannel = fileInputStream.getChannel();
        FileChannel fileOutputChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        while (fileInputChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            fileOutputChannel.write(byteBuffer);
            byteBuffer.flip();
        }
    }
}
