package com.azy.reflect;

import com.azy.bean.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest1 {
    @Test
    public void test1() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();

        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);

        age.set(person,1000);

        System.out.println(age.get(person));
    }


    @Test
    public void test2() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();

        //非静态方法
        Method show = personClass.getDeclaredMethod("show", String.class);

        show.setAccessible(true);

        Object returnValue = show.invoke(person, "China");
        System.out.println(returnValue);

        //静态方法
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

        Object invoke = showDesc.invoke(personClass);
        System.out.println(invoke);


    }



}
