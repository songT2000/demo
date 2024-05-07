package com.demo.portal.test.zerocopy;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(7000);

        while(true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            try {
                while(true){
                    byte[] bytes = new byte[4096];
                    int readCount = dataInputStream.read(bytes);
                    if(readCount == -1){
                        break;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
