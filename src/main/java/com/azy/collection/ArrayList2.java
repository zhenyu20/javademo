package com.azy.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
        list.add(0,444);

        //Arrays的asList方法对于引用数据类型和基本数据类型数组的不同
        Integer[] arr1 = new Integer[]{1,2,3,4,5,6};
        int[] arr2 = new int[]{1,2,3,4,5,6};
        List<Integer> list2 = Arrays.asList(arr1);
        List<int[]> list3 = Arrays.asList(arr2);

    }

    private static void updateList(List list) {
        list.remove(2);
    }
}
