package com.azy.leetcode;

import java.util.Scanner;

/**
 * 2023-11-01 19:59:02
 */
public class UnionFindSet {
    private static int[] father;
    private void union(int u,int v){
        u = find(u);
        v = find(v);
        if(u == v) return;
        father[v] = u;
    }
    private int find(int u){
        return u == father[u] ? u : (father[u] = find(father[u]));
    }
    private boolean isSame(int u,int v){
        u = find(u);
        v = find(v);
        return u == v;
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int n = 10;
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        UnionFindSet unionFindSet = new UnionFindSet();
        unionFindSet.union(1, 8);
        unionFindSet.union(3, 8);
        unionFindSet.union(1, 7);
        unionFindSet.union(8, 5);
        unionFindSet.union(2, 9);
        unionFindSet.union(6, 2);

        boolean same = unionFindSet.isSame(1, 3);
        System.out.println(same);

    }

}
