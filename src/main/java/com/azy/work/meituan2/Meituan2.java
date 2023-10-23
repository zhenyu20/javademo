package com.azy.work.meituan2;

import java.util.Scanner;

/*
* 9/9
* */
public class Meituan2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        int max = Integer.MIN_VALUE;
        int currSum = a[0];
        for (int i = 1; i < n; i++) {
            if (currSum > a[i]) {
                max = Math.max(max, a[i]);
            }
            currSum += a[i];
        }
        System.out.println(max == Integer.MIN_VALUE ? -1 : sum - 2 * max);
    }
}
