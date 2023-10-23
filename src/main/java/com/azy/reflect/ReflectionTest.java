package com.azy.reflect;

import com.azy.java.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        Field[] field = personClass.getFields();
        for(Field f : field){
            System.out.println(f);
        }

        System.out.println();

        Field[] field1 = personClass.getDeclaredFields();
        for(Field f : field1){
            System.out.println(f);
        }
    }
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        for(Method f : methods){
            System.out.println(f);
        }

        System.out.println();

        Method[] declaredMethods = personClass.getDeclaredMethods();
        for(Method f : declaredMethods){
            System.out.println(f);
        }
    }

    @Test
    public void test3(){
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getConstructors();
        for(Constructor f : constructors){
            System.out.println(f);
        }

        System.out.println();

        Constructor<?>[] constructors1 = personClass.getDeclaredConstructors();
        for(Constructor f : constructors1){
            System.out.println(f);
        }
    }

    @Test
    public void test6(){
        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }
}
