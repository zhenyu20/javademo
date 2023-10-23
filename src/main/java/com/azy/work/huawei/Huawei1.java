package com.azy.work.huawei;

import java.util.Scanner;

public class Huawei1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int num = 0;
        int b = 0;
        for (int i = 0; i <= n; i++) {
            if (b > 0){
                if(b + a[i] < k) {
                    num++;
                    b = 0;
                }else {
                    num += (a[i] + b) / k;
                    b = (a[i] + b) % k;
                }
            } else {
                num += a[i] / k;
                b = a[i] % k;
            }
        }
        System.out.println(num);
    }
}
