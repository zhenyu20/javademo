package com.azy.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayList2 {
    public static void main(String[] args) {
        List list = new ArrayList();
            list.add(1);
            list.add(2);
            list.add(3);
            updateList(list);
            System.out.println(list);//



    }
    private static void updateList(List list) {
        list.remove(2);
    }
}
