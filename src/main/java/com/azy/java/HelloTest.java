package com.azy.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract  class HelloTest {
    public static void main(String[] something_to_do) {
        System.out.println("Do something ...");
        Map<Integer,Integer> m = new  HashMap<>();
        m.put(null,12);//hashmap可以存放空值
        m.put(2,12);
        m.put(7,12);
        m.put(4,12);
        m.put(5,12);
        for (Integer key : m.keySet()){
            System.out.println(key +  " "+ m.get(key));
        }

        char[] c = {'a','b','c','d','e','f'};
        System.out.println(Arrays.toString(c));//[a, b, c, d, e, f]
        System.out.println(c.length);

        String s = "111111000";
        System.out.println(getOne(s));
    }
    private static int getOne(String str){
        int v = Integer.parseInt(str);
        int cnt = 0;
        while(v != 0){
            if((v & 1) == 1) cnt++;
            v = v >>> 1;
        }
        return cnt;
    }

    @Test
    public void test1(){
        //测试数溢出
		 int a = Integer.MIN_VALUE;
		int c = 1 - a;
		System.out.println(a);
		System.out.println(c);
		int b = Integer.MIN_VALUE / 2;
		c = 1 - b;
		System.out.println(b);
		System.out.println(c);
    }

    @Test
    public void test2() {
        //测试短路&&
		int[] a = new int[2];
		int index = -1;
		if(index >= 0 && a[index] >= 0 && a[index] < 1){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
    }

    @Test
    public void test3() {
        ArrayList<Object> a = new ArrayList<>();
        a.add("ssss");
        a.add(1);
        a.add('c');
        System.out.println(a);
    }
    @Test
    public void test() {

    }
}

