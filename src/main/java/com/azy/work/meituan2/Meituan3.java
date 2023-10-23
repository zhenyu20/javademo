package com.azy.work.meituan2;

public class Meituan3 {
    //原来使用回溯的方法，有误
//    static int length = Integer.MAX_VALUE;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        char[] a = new char[n];
//        String s = sc.next();
//        for (int i = 0; i < n; i++) {
//            a[i] = s.charAt(i);
//        }
//        int[] visit = new int[n + 1];//visit为标记数组
//        dfs(0,a,visit,k);
//        System.out.println(length);
//    }
//
//
//    public static int stack(char[] a) {
//        int cnt = 0;
//        StringBuilder s = new StringBuilder();
//        s.append(a[0]);
//        for (int i = 1; i < a.length; i++) {
//            if(cnt >=0 && a[i] == s.charAt(cnt)){
//                s.deleteCharAt(cnt);
//                cnt--;
//            }else{
//                s.append(a[i]);
//                cnt++;
//            }
//        }
//        return s.length();
//    }
//
//    //回溯
//    public static void dfs(int d, char[] a, int[] visit, int k) {
//        if (d == k) {
//            length = Math.min(length,stack(a));
//        }
//        for (int i = 1; i < a.length; i++) {
//            if(visit[i] == 0 && a[i] == '0'){
//                a[i] = '1';
//                visit[i] = 1;
//                dfs(d + 1, a,visit,k);
//                visit[i] = 0;
//                a[i] = '0';
//            }else if(visit[i] == 0 && a[i] == '1'){
//                a[i] = '0';
//                visit[i] = 1;
//                dfs(d + 1, a,visit,k);
//                visit[i] = 0;
//                a[i] = '1';
//            }
//        }
//    }
    //先把能消除的都先消除掉，再进行比较
}
