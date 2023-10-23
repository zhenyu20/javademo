package com.azy.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>2023-10-13 12:51:47</p>
 * 从n个数中选出m个数，使得他的和为k，问有几种方案，使用动态规划解决
 * 和01背包问题相似，此处用第二维来控制选取数的个数
 */
public class ChooseSumFromNtoK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = (n + 1) >> 1;
        int k = sc.nextInt();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        System.out.println(solve(nums, m, k, sum));
    }

        public static int solve2(int[] nums, int m, int k,int sum) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][m + 1][sum + 1];//第二维来控制选取数的个数
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int p = 0; p <= sum; p++) {
                    dp[i][j][p] = dp[i - 1][j][p];
                    if (j >= 1 && p >= nums[i - 1]) {
                        dp[i][j][p] += dp[i - 1][j - 1][p - nums[i - 1]];
                    }
                }
            }
        }
        int cnt = 0;
        for (int p = k; p <= sum; p++) {
            cnt += dp[n][m][p];
        }
        return cnt;
    }
    public static int solve(int[] nums, int m, int k, int sum) {
        int n = nums.length;
        int[][] dp = new int[m + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {//逆序
                for (int p = sum; p >= nums[i - 1]; p--) {//逆序
                    dp[j][p] += dp[j - 1][p - nums[i - 1]];
                }
            }

        }
//        for (int j = 1; j <= m; j++) {
//            for (int p = 0; p <= sum; p++) {
//                System.out.print(dp[j][p]);
//            }
//            System.out.println();
//        }
        int cnt = 0;
        for (int p = k; p <= sum; p++) {
            cnt += dp[m][p];
        }
        return cnt;
    }

}
