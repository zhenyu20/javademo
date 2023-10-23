package com.azy.work.haier;

import java.util.Arrays;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        One  one = new One();
        int[] result = one.placement(n,a);
        System.out.println(Arrays.toString(result));
    }
    public int[] placement(int n,int[] a){
        int[] b = new int[n];
        b[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(a[j] > a[i]){
                    b[i]++;
                }
            }
        }
        return b;
    }
}
