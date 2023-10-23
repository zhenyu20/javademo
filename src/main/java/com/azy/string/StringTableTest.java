package com.azy.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StringTableTest {

    public static void main(String[] args) {

    }

    @Test
    public void test3() {
        String str = null;
//        StringBuffer sb = new StringBuffer();
        StringBuilder sb1 = new StringBuilder();
        sb1.append(str);
        System.out.println(sb1.length());//4
        System.out.println(sb1);//null
//        StringBuffer sb2 = new StringBuffer(str);
//        System.out.println(sb2);//空指针
    }

    @Test
    public void test4() {
        /*
        * 5个对象：
        * StringBuilder（拼接操作）
        * new String
        * 常量池的a
        * new String
        * 常量池的b
        * 最后的对象在堆里，常量池中并没有
        *
        * */
        String str = new String("a") + new String("b");
    }
    @Test
    public void test5() {
        String s = new String("a");
        s.intern();
        String s2 = "a";
        System.out.println(s == s2);//false

        String s3 = new String("a") + new String("b");
        s3.intern();//jdk7之后会把ab字符串的引用放到字符串常量池中
        String s4 = "ab";
        System.out.println(s3 == s4);//true
    }

    @Test
    public void test6() {
        String str = new String("abcdefg");
        char[] ch = new char[5];
        str.getChars(1,5,ch,0);
        System.out.println(ch);
    }
    @Test
    public void test() {

    }

}

