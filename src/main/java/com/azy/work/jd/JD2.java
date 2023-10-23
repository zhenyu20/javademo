package com.azy.work.jd;

import java.util.Scanner;

public class JD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        dp[0] = 0;
        dp[1] = a[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + a[i];
        }
        System.out.println(dp[n - 1]);
    }
}
