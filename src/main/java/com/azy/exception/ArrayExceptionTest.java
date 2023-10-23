package com.azy.exception;

public class ArrayExceptionTest {
    public static void main(String[] args) {
        //ArrayIndexOutOfBoundException
        int[] a = new int []{1,2,3,4};
//        a[5] = 0;

        //空指针异常NullPointerException
        a = null;
        System.out.println(a[1]);
    }
}
