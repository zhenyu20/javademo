package com.azy.work.huawei;


import java.util.Scanner;

public class Huawei2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] graph = new int[M][M];
        boolean[] visit = new boolean[M];
        for (int i = 0; i < N; i++) {
            int in = sc.nextInt();
            int out = sc.nextInt();
            graph[in][out] = 1;
            graph[out][in] = 1;
        }
        int ans = 0;
        for (int i = 0; i < M; ++i) {
            if(!visit[i]){
                dfs(graph, visit, i);
                ++ans;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int[][] graph, boolean[] visit, int i) {
        visit[i] = true;
        for (int j = 0; j < graph[i].length; ++j) {
            if (!visit[j] && graph[i][j] == 1) {
                dfs(graph, visit, j);
            }
        }
    }


}
