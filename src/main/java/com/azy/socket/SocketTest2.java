package com.azy.socket;

import org.junit.Test;

import java.io.*;
import java.net.*;


public class SocketTest2 {
    @Test
    public void client(){

        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();

            byte[] by = "hello 你好啊！".getBytes();

            DatagramPacket datagramPacket = new DatagramPacket(by,by.length, InetAddress.getByName("127.0.0.1"),8888);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(datagramSocket != null){
                datagramSocket.close();
            }
        }
    }

    @Test
    public void server() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8888);

            byte[] by = new byte[20];
            DatagramPacket datagramPacket = new DatagramPacket(by,0,by.length);
            datagramSocket.receive(datagramPacket);
            String data = new String(datagramPacket.getData());
            System.out.println(data);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(datagramSocket != null){
                datagramSocket.close();
            }
        }
    }
}
