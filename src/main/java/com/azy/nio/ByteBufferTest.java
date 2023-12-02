package com.azy.nio;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * 2023-11-26 15:05:56
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 65);

        buffer.flip();
        while(buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
    }
}
