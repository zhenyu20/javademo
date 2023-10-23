package com.azy.work.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] a = new double[n];
        double[] b = new double[n];
        double[] c = new double[n];
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextDouble();
            if (a[i] == 0 && b[i] == 0){//特殊情况
                cnt++;
            }else {
                c[i] = b[i] / a[i];
            }
            int value = map.get(c[i]) == null ? 0 : map.get(c[i]);
            map.put(c[i], ++value);
        }
        int num = 0;
        for (Double d : map.keySet()) {
            num = Math.max(map.get(d), num);
        }
        System.out.println(num + cnt);
    }
}
