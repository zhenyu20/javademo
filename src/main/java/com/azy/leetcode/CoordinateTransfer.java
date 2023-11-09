package com.azy.leetcode;

import java.util.Scanner;

/**
 * 2023-11-07 19:01:52
 */
public class CoordinateTransfer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dx = new int[n];
        int[] dy = new int[n];
        int[] x = new int[m];
        int[] y = new int[m];
        for (int i = 0; i < n; i++) {
            dx[i] = sc.nextInt();
            dy[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[i] += dx[j];
                y[i] += dy[j];
            }
            System.out.println(x[i] + " " + y[i]);
        }
    }
}
