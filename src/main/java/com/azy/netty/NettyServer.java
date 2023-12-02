package com.azy.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.*;
import io.netty.handler.codec.string.StringDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2023-11-26 14:49:58
 */

public class NettyServer {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(NettyServer.class);
//        DefaultEventLoopGroup defaultEventLoopGroup = new DefaultEventLoopGroup();
        new ServerBootstrap()
                .group(new NioEventLoopGroup(1), new NioEventLoopGroup()) // 1
                .channel(NioServerSocketChannel.class) // 2
                .childHandler(new ChannelInitializer<NioSocketChannel>() { // 3
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast("handler1", new StringDecoder()); // 5
                        ch.pipeline().addLast("handler2", new SimpleChannelInboundHandler<String>() {
                            @Override
                            public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//                                System.out.println(msg);
                                log.debug("{}", msg);
                            } // 6
                        });
                    }
                })
                .bind(8080); // 4
    }
}
