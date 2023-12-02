package com.azy.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import static com.azy.netty.ByteBufUtils.log;

/**
 * 2023-11-27 15:52:35
 */
public class ByteBufTest1 {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(4);
        buffer.writeBytes(new byte[]{65,66,67});
        log(buffer);
        buffer.writeInt(2345);
        log(buffer);
        System.out.println(buffer.readByte());
        log(buffer);
        buffer.markReaderIndex();
        System.out.println(buffer.readByte());
        buffer.resetReaderIndex();
        System.out.println(buffer.readByte());
    }
}
