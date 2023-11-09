package com.azy.leetcode;

import java.util.Scanner;

/**
 * 2023-11-07 19:01:52
 */
public class CoordinateTransfer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] op = new int[n];
        double[] k = new double[n];
        double[] Ks = new double[n + 1];
        double[] Es = new double[n + 1];
        Ks[0] = 1.0;
        for (int i = 0; i < n; i++) {
            op[i] = sc.nextInt();
            k[i] = sc.nextDouble();
            if (op[i] == 1) {
                Ks[i + 1] = Ks[i] * k[i];
                Es[i + 1] = Es[i];
            } else {
                Ks[i + 1] = Ks[i];
                Es[i + 1] = Es[i] + k[i];
            }
        }
        for (int l = 0; l < m; l++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double K = Ks[j] / Ks[i - 1];
            double E = Es[j] - Es[i - 1];
            x *= K;
            y *= K;
            double newX = x * Math.cos(E) - y * Math.sin(E);
            double newY = x * Math.sin(E) + y * Math.cos(E);
            x = newX;
            y = newY;
            System.out.println(x + " " + y);
        }
    }
}
