package com.azy.array;

public class ArrayTest1 {
    public static void main(String[] args) {
        String[] names = new String[5];
        //二维数组静态
        int[][] ints = new int[][]{{123, 12}, {123, 11}, {123}};
        int[][] ins = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                ins[i][j] = 0;
                System.out.println(ins[i][j]);
            }
        }
        //二维数组动态
        int[][] a = new int[3][];
        for (int i = 0; i < 3; i++) {
            a[i] = new int[3];
        }

//      C++写法
//        int **a = new int *[3];
//        for (int i = 0; i < 3; i++) {
//            a[i] = new int[3];
//        }
    }
}
