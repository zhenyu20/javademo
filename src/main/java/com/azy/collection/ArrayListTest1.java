package com.azy.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* 1、List<Integer>不是List<Object>的子类
* 2、无法创建泛型数组
* 3、不能在static的普通方法中使用泛型,但是可以定义泛型方法
* */

public class ArrayListTest1 {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        ArrayListTest1 al = new ArrayListTest1();
        al.printCollection(l1);
//        al.printCollection2(l1);//报错，List<Integer>不是List<Object>的子类
        System.out.println("-----------------");
//        Object[] arrays = l1.toArray();
        Integer[] arrays1 = l1.toArray(new Integer[6]);
        for (Integer a : arrays1) {
            System.out.println(a);
        }
        System.out.println("------------------");
//        ArrayList<Integer>[] al1 = new ArrayList<Integer>[10];//无法创建泛型数组
        ArrayList<Integer>[] al1 = (ArrayList<Integer> []) new ArrayList[10];

//        ArrayListTest1.test(1);//不能再static的普通方法中使用泛型,但是可以定义泛型方法

    }
    public void printCollection(List c) {
        Iterator i = c.iterator();
        for (int k = 0; k < c.size(); k++) {
            System.out.println(i.next());
        }
    }
    public void printCollection2(List<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

//    public static void test(E  e){
//        System.out.println("测试static普通方法中使用泛型");
//    }
    public static <E> void test(E  e){
        System.out.println("测试static泛型方法");
    }
}
