package com.azy.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 2023-10-24 12:55:03
 */
public class QueueTest1 {
    public static void main(String[] args) {
        Queue<Integer>  queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(13);
        queue.add(14);
        queue.add(15);
        queue.forEach(System.out::println);
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(13);
        deque.push(14);
        deque.push(15);
        deque.forEach(System.out::println);
    }
}
