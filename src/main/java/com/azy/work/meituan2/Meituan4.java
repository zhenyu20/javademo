package com.azy.work.meituan2;

import java.util.Arrays;
import java.util.Scanner;

public class Meituan4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        a[0] = 1;
        int num = 1;
        int index = n;
        for (int i = 1; i < n; i++) {
            if(a[i - 1] + num > m){
                index = i;
                break;
            }else {
                a[i] = a[i - 1] + num;
                num++;
            }
            if(n - i - 1 > m - a[i] ){
                index = i;
                break;
            }
        }
        for (int i = index; i < n ; i++) {
            a[i] = a[i - 1] + 1;
        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(a[i] + " ");//注意不要写成' '
//        }
//        for(int i : a){
//            System.out.print(" " + i);
//        }
        System.out.println(Arrays.toString(a));

    }
}
