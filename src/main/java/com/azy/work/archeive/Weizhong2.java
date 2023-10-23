package com.azy.work.archeive;

import java.util.Scanner;

public class Weizhong2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            sb.append(a);
        }
        int t = n;
        while(t > 0) {
            System.out.print(sb.charAt(0) + " ");
            sb.deleteCharAt(0);
            if(sb.length() > 0) {
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
            }
            t--;
        }
    }
}
