package com.azy.work.ctrip;

import java.util.Scanner;


/*
 * */
public class Ctrip2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] str = new String[n];
        int[][] row = new int[n][3];
        int[][] col = new int[3][m];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
            for (int j = 0; j < str[i].length(); j++) {
                switch (str[i].charAt(j)) {
                    case 'y': {
                        row[i][0]++;
                        col[0][j]++;
                        break;
                    }
                    case 'o': {
                        row[i][1]++;
                        col[1][j]++;
                        break;
                    }
                    case 'u': {
                        row[i][2]++;
                        col[2][j]++;
                        break;
                    }
                }
            }
        }
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < str[i].length(); j++) {
                switch (str[i].charAt(j)) {
                    case 'y': {
                        count += row[i][1] * col[2][j] + row[i][2] * col[1][j];
                        break;
                    }
                    case 'o': {
                        count += row[i][0] * col[2][j] + row[i][2] * col[0][j];
                        break;
                    }
                    case 'u': {
                        count += row[i][0] * col[1][j] + row[i][1] * col[0][j];
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
