package com.azy.work.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>2023-10-15 12:33:01</p>
 * 10/15上午
 */
public class Byte01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            a[i] -= p;
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            b[i] -= p;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(a[i] - b [i]) + Math.abs(b[i]);
        }
        System.out.println(sum);
    }
}
