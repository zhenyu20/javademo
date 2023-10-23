package com.azy.work.ctrip;

import java.util.Scanner;

public class Ctrip1 {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] visit = new int[n + 1];//visit为标记数组
        for (int i = 1; i <= n; i++){
            visit[i] = 1;
            dfs(i,2,visit,n);
            visit[i] = 0;
        }
        System.out.println(count);
    }

    /*判断是否为素数*/
    public static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++)
            if (x % i == 0)
                return false;
        return true;
    }
//    public static int[] isPrime(int x){
//        boolean[] notPrime =new boolean[x];
//        int[] prime = new int[1000];
//        int cnt = 0;
//        for (int i = 2; i <= x; i++) {
//            if(!notPrime[i]) prime[cnt++] = i;
//            for (int j = 0; j < cnt && prime[j] * i <= x; j++) {
//                notPrime[prime[j] * i] = true;
//                if(i % prime[j] == 0) break;
//            }
//        }
//        return prime;
//    }

    //回溯
    public static void dfs(int x, int y, int[] visit, int n) {
        if (y == n + 1) {
            count++;
        }
        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0 && !isPrime(x + i)) //x与其他没有遍历过的点进行比较判断
            {
                visit[i] = 1;//标记
                dfs(i, y + 1, visit,n); //递归
                visit[i] = 0;//恢复现场
            }
        }
    }
}
