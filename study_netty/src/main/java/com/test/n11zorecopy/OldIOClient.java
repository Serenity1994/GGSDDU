package com.test.n11zorecopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class OldIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8899);
        String fileName = "/Users/serenityma/Documents/[第 6 季.Ep16] 马男波杰克 - 好的时候很好.mp4";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        byte[] buf = new byte[4096];
        long readCount;
        long total = 0;
        long startTime = System.currentTimeMillis();
        while ((readCount = fileInputStream.read(buf)) > 0) {
            total += readCount;
            dataOutputStream.write(buf);
        }
        System.out.println("total:" + total + ";耗时:" + (System.currentTimeMillis() - startTime));
    }
}
