package com.azy.leetcode;

import java.util.Scanner;

/**
 * <p>2023-10-12 16:37:59</p>
 * 01背包问题
 */
public class Bag01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bagWeight = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        int maxValue = solve01Bag(weight, value, bagWeight);
        System.out.println(maxValue);
    }

    //二维
    private static int solve01Bag2(int[] weight, int[] value, int bagWeight) {
        int n = weight.length;
        int[][] dp = new int[n][bagWeight + 1];
        for (int j = weight[0]; j <= bagWeight; j++) {
            dp[0][j] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][bagWeight];
    }
    //一维
    private static int solve01Bag(int[] weight, int[] value, int bagWeight) {
        int n = weight.length;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }
    //完全背包
    private static int solveWholeBag(int[] weight, int[] value, int bagWeight) {
        int n = weight.length;
        int[] dp = new int[bagWeight + 1];
        for (int i = 1; i < n; i++) {
            for (int j = weight[i]; j < bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[bagWeight];
    }
}
