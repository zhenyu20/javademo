package com.azy.array;

import java.util.Arrays;

public class ArraysTest1 {
    public static void main(String[] args) {
        int[] a1 = new int[] {1,2,3};
        int[] a2 = {2,3,4};
        //equals(a,a)比较是否相等
        boolean equals = Arrays.equals(a1, a2);
        System.out.println(equals);

        //fill(a,1)用元素填充数组 fromIndex <= index < toIndex
        Arrays.fill(a1,1,2,1);//[1, 1, 3]
        System.out.println(Arrays.toString(a1));

        //sort
        Arrays.sort(a1);
        System.out.println(Arrays.toString(a1));

        //binarySearch
        int search = Arrays.binarySearch(a1, 4);
        if(search>=0)
            System.out.println(search);
        else System.out.println("没找到！");
    }
}
