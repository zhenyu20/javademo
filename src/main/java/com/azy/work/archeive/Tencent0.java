package com.azy.work.archeive;

import java.util.*;

public class Tencent0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] p = new int[n];
        int[] v = new int[n];
        int[] p1 = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            p1[i] = p[i] + t * v[i];
            p[i] = p1[i];
        }
        Arrays.sort(p1);
        int num = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if(p[i] == p1[j]){
                    index = j;
                    break;
                }
            }
            if(index > i){
                num++;
            }
        }
        System.out.println(num);
    }
}
