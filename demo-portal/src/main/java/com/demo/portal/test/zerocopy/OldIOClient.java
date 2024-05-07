package com.demo.portal.test.zerocopy;

import java.io.*;
import java.net.Socket;

public class OldIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 7000);
        File file = new File("D:\\software\\HTMLtoexe1_jb51.rar");
        FileInputStream fileInputStream = new FileInputStream(file);
        //socket的输出流
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        long startTime = System.currentTimeMillis();
        byte[] bytes = new byte[4096];
        long readCount = 0;
        long total = 0;
        while ((readCount = fileInputStream.read(bytes)) >= 0) {
            total += readCount;
            dataOutputStream.write(bytes);
        }
        System.out.println("总发送字节数:" + total + "总耗时:" + (System.currentTimeMillis() - startTime));
    }
}
