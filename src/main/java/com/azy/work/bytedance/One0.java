package com.azy.work.bytedance;

import java.util.Scanner;


/*前端题目*/
public class One0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
            c[i] = Math.max(a[i], b[i]);
            sum +=c[i];
        }
        System.out.println(sum);
        for (int i = 0; i < q; i++) {
            int op = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(op == 1){
                int temp = a[x];
                a[x] = a[y];
                a[y] = temp;
                sum += Math.max(a[x], b[x]) - c[x];
                sum += Math.max(a[y], b[y]) - c[y];
            } else if (op == 0) {
                int temp = b[x];
                b[x] = b[y];
                b[y] = temp;
                sum += Math.max(a[x], b[x]) - c[x];
                sum += Math.max(a[y], b[y]) - c[y];
            }
            System.out.println(sum);
        }
    }
}
