package com.azy.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum3 {
    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        backTracking(1,0,k,n);
        System.out.println(res);
    }

    public static void backTracking(int startIndex,int sum,int k,int targetSum){
        if(path.size() == k){
            if(sum == targetSum) {
                res.add(new ArrayList<Integer>(path));//必须要新new一个
            }
            return;
        }
        for(int i = startIndex; i < 10;i++){
            path.addLast(i);
            sum += i;
            backTracking(i+1,sum,k,targetSum);
            sum -= i;
            path.removeLast();
        }

//        if (path.size() == k) {
//            if (sum == targetSum) res.add(new ArrayList<>(path));
//            return;
//        }
//
//        // 减枝 9 - (k - path.size()) + 1
//        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
//            path.add(i);
//            sum += i;
//            backTracking(i + 1,sum, k, targetSum);
//            //回溯
//            path.removeLast();
//            //回溯
//            sum -= i;
//        }
    }
}
