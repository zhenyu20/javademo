package com.azy.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2023-11-24 15:42:48
 */
public class Server {
    public static void main(String[] args){
        try (
                ServerSocket serverSocket = new ServerSocket(8888);
                Socket socket = serverSocket.accept();
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream()
        ){
            byte[] data = new byte[1024];
            int len;
            while ((len = in.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
            }

            out.write("kill Finished".getBytes());
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
