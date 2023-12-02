package com.azy.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.*;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * 2023-11-26 16:11:43
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Logger log = LoggerFactory.getLogger(NettyClient.class);
        NioEventLoopGroup group = new NioEventLoopGroup();
        ChannelFuture channelFuture = new Bootstrap()
                .group(group) // 1
                .channel(NioSocketChannel.class) // 2
                .handler(new ChannelInitializer<Channel>() { // 3
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                        ch.pipeline().addLast(new StringEncoder()); // 8
                    }
                })
                .connect("127.0.0.1", 8080);// 4 异步非阻塞，main调用，NIO线程建立连接

            ChannelFuture future = channelFuture.sync();// 5 同步处理结果： 阻塞等待NIO线程完成
//            future.channel().writeAndFlush("hello");
        Channel channel = future.channel();

//        channelFuture.addListener(new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) throws Exception {
//                future.channel().writeAndFlush("hello");
//            }
//        });//5 异步处理结果：NIO线程完成连接后调用operationComplete方法

        new Thread(() -> {
            while(true){
                Scanner scanner = new Scanner(System.in);
                String line = scanner.nextLine();
                if("q".equals(line)){
                    channel.close();//调用另一个线程
                    break;
                }
                channel.writeAndFlush(line);
            }
        },"output").start();

        //同步方法
        ChannelFuture closeFuture = channel.closeFuture();
//        closeFuture.sync();
//        log.debug("结束");
//        group.shutdownGracefully();

        //异步方法
        closeFuture.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                log.debug("结束");
                group.shutdownGracefully();
            }
        });



    }
}
