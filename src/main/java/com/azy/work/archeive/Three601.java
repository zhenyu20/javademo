package com.azy.work.archeive;

import java.util.Scanner;

public class Three601 {
    static int num = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(nums, 0, 0, 0, k);
        System.out.println(num);
    }

    static void dfs(int[] nums, int startIndex, int sum, int cnt, int k) {
        int n = nums.length;
        if (cnt == (n + 1) >> 1) {
            if (sum >= k) num++;
            return;
        }
        for (int j = startIndex; j <= n - (((n + 1) >> 1) - cnt); ++j) {//剪枝
            cnt++;
            sum += nums[j];
            dfs(nums, j + 1, sum, cnt, k);
            sum -= nums[j];
            cnt--;
        }
    }

}
