package com.azy.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 2023-11-24 15:26:18
 */
public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
                OutputStream out = socket.getOutputStream();
                InputStream in = socket.getInputStream();
        ) {
            out.write("killall".getBytes());
            out.flush();
            socket.shutdownOutput();//在流末尾标记才能读到-1

            byte[] data = new byte[1024];
            int len;
            while ((len = in.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
