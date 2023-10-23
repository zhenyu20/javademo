package com.azy.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest1 {
    @Test
    public void test4() {
        LocalDateTime lt =LocalDateTime.now();
        System.out.println(lt);

        System.out.println(lt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS")));
    }
}
