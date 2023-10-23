package com.azy.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest1 {

    /*
    * Calendar类：抽象类
    *       方式一：GregorianCalendar子类对象
    *       方式二：静态方法Calendar.getInstance()方法
    *
    * */
    @Test
    public void test4(){

        //get()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //set()修改某一属性
        //add()对某一属性加减
        //getTime() Calendar-->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime()  Date-->Calendar
    }

    /*
    * SimpleDateFormat类
    * 方法：
    *   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    *   format(date)
    *   parse(str)
    * */
    @Test
    public void test3() throws ParseException {
        //SimpleDateFormat默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //Date类
        Date date = new Date();
        System.out.println(date);
        //Date-->String格式化
        String format = sdf.format(date);
        System.out.println(format);

        //String-->Date解析
        String str = "22-7-4 下午5:12";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        /********************************/
        //SimpleDateFormat带格式的构造器，一般使用这个HH为24小时制，hh为12小时制
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);

        str = "2022-07-04 17:22:35";
        Date date2 = sdf1.parse(str);
        System.out.println(date2);

    }
    /*
    * Date类：
    * java.util.Date
    *   |--java.sql.Date
    *
    *方法：
    *   toString()
    *   getTime()
    * */
    @Test
    public void test2(){
        //构造一
        Date date = new Date();
        System.out.println(date.toString());//Mon Jul 04 15:20:19 CST 2022
        System.out.println(date.getTime());//1656919219553
        //构造二
        Date date1 = new Date(1656919219553L);
        System.out.println(date1.toString());//Mon Jul 04 15:20:19 CST 2022

        java.sql.Date date2 = new java.sql.Date(1656919219553L);
        System.out.println(date2.toString());//2022-07-04
    }


    /*System类
    * */
    @Test
    public void test1(){
        long millis = System.currentTimeMillis();
        System.out.println(millis);
    }
}
