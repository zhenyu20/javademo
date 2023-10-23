package com.azy.work.meituan2;

import java.util.Scanner;


/*
*
* http://t.csdn.cn/yYjFN
* 两两数字异或之后求和
* */
public class XorSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ans = new int[32];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int len = 31;
            while (num > 0) {
                if ((num & 1) == 1) ans[len]++;//记录当前位为1的个数
                num = num >> 1;
                len--;
            }
        }
        int sum = 0;
        for (int j = 31; j >= 0; j--) {
            sum +=  (long)(1 << (31 - j)) * (long)ans[j] * (long)(n - ans[j]);
        }
        System.out.println(sum);
    }
}
