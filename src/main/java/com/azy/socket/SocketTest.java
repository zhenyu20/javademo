package com.azy.socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketTest {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is  = null;
        ByteArrayOutputStream baos = null;
        try {
            //1、造socket
            socket = new Socket("127.0.0.1", 8345);

            //2、获取输出流
            os = socket.getOutputStream();

            //传文件
            fis = new FileInputStream("原神.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer)) != -1 ){
                os.write(buffer,0,len);
            }

            socket.shutdownOutput();//说明不再传输输出

            //收到反馈
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1 ;
            while ((len1 = is.read(buffer1)) != -1){
                baos.write(buffer1,0,len1);
            }
            System.out.println(baos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3、资源关闭
            if(baos != null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void server(){
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        ServerSocket ss  = null;
        try {
            //1、创建服务端socket
            ss = new ServerSocket(8345);
            //2、利用accept()获取socket
            socket = ss.accept();
            //3、获取输入流
            is = socket.getInputStream();

            //接受文件
            fos = new FileOutputStream("原神2.jpg");
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            //反馈
            OutputStream os = socket.getOutputStream();
            os.write("照片已收到！".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
