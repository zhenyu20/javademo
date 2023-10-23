package com.azy.work.jd;

import java.util.Arrays;
import java.util.Scanner;

/*
* 9/9
* */
public class JD1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        long sum = 0;//10e10
        for (int i = n - 1; i >= 1; ) {
            if (a[i] - a[i - 1] <= k) {
                sum += (long) a[i] * a[i - 1];
                i-=2;
            }else {
                i--;
            }
        }
        System.out.println(sum);
    }
}
