package com.azy.work.jd;

import java.util.Scanner;

//权值和
//https://zhuanlan.zhihu.com/p/655353541

public class JD3WeightSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum +=  a[i] * (long)(i + 1) * (i + 2) / 2 * (n - i);
        }
        System.out.println(sum % (100000007));
    }
}
