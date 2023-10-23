package com.azy.work.haier;

import java.util.*;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Two two = new Two();
        int result = two.placement(n,k,a);
        System.out.println(result);
    }

    int placement(int n, int k ,int[] a){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(a[i]);
        }
        return set.size();
    }
}
