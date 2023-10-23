package com.azy.work.bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>2023-10-15 12:33:01</p>
 * 10/15上午
 */
public class Byte03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[n][3];
        for (int i = 0; i < n; i++) {
            res[i][0] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            res[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            res[i][2] = sc.nextInt();
        }
        Arrays.sort(res,(a,b) ->{
            if(a[0] != b[0]){
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            }else{
                return b[2] - a[2];
            }
        });
        int sum = res[0][2];
        for (int i = 1; i < n; i++) {
            if(res[i][0] == res[i - 1][0] && res[i][1] == res[i - 1][1] ){
                sum += res[i][2]/2;
            }else{
                sum += res[i][2];
            }
        }
        System.out.println(sum);
    }
}
