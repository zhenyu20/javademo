package com.azy.leetcode;

import java.util.Scanner;

/**
 * <p>2023-10-12 16:37:59</p>
 * 多重背包问题
 */
public class BagN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int bagWeight = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int maxValue = solveNBag(weight, value, nums,bagWeight);
        System.out.println(maxValue);
    }

    //一维
    private static int solveNBag(int[] weight, int[] value, int[] nums,int bagWeight) {
        int n = weight.length;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                for (int k = 1; k <= nums[i] && k * weight[i] <= j; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k *weight[i]] + k * value[i]);
                }
            }
        }
        return dp[bagWeight];
    }
}
