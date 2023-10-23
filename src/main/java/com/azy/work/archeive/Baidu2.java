package com.azy.work.archeive;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baidu2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[k + 1];
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (i < k) {
                m.put(a[i], i + 1);
            }
            m1.put(a[i], i + 1);
        }
        for (int i = 1; i <= k; i++) {
            if (m.get(i) != null) {
                b[i] = m.get(i);
            } else {
                b[i] = -1;
            }
        }
//        System.out.println( Arrays.toString(b));
        int cnt = 0;
        int index = 0;
        for (int i = 1; i <= k; i++) {
            if (b[i] == -1) {
                cnt++;
                index = i;
            }
        }
        boolean flag = true;
        if (cnt > 1) {
            flag = false;
        } else if (index > 1 && index < k && (b[index - 1] + 2 != b[index + 1])) {
            flag = false;
        }
        System.out.println(flag ? "YES" : "NO");
        if (flag)
            if (index == 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
                if (index < k && index > 0) {
                    System.out.print(b[index + 1] - 1);
                    System.out.print(" ");
                    System.out.println(m1.get(index));
                } else {
                    System.out.print(b[index - 1] + 1);
                    System.out.print(" ");
                    System.out.println(m1.get(index));
                }
            }
    }

}
