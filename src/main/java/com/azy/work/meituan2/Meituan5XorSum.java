package com.azy.work.meituan2;

import java.util.Scanner;


/*
*
* 小美定义一个数组的权值为:数组中任选两个数的异或之和。
* 例如,数组(2,1,3]的权值为:(2 xor 1)+(2 xor 3)+(1 xor 3)=3+1+2=6.
* 小美拿到了一个数组,她想知道该数组的所有 连续子数组 的权值和是多少?答案对10e +7取模。
* https://wbd.ms/share/v2/aHR0cHM6Ly93aGl0ZWJvYXJkLm1pY3Jvc29mdC5jb20vYXBpL3YxLjAvd2hpdGVib2FyZHMvcmVkZWVtLzcwMWRiYTI3M2NkZTRmYWY5ZjYwMzBiNWE2ZTEyMThlX0JCQTcxNzYyLTEyRTAtNDJFMS1CMzI0LTVCMTMxRjQyNEUzRF9mZDA3NTM4ZC0xZDJlLTRiZWItYmU2ZC1jYzAzMWJhNDQ4YTI=
* */
public class Meituan5XorSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
    }
}
