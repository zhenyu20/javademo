package com.azy.leetcode;


import java.util.*;

public class NQueens {
    static List<List<String>> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for (char[] b : board) {
            Arrays.fill(b, '.');
        }
        backtracking(board, n, 0);
        System.out.println(res);
    }

    private static void backtracking(char[][] board, int n, int i) {
        if (i == n) {
            res.add(array2List(board));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(board, i, j, n)) {
                board[i][j] = 'Q';
                backtracking(board, n, i + 1);
                board[i][j] = '.';
            }
        }
    }

    private static boolean isValid(char[][] board, int row, int col, int n) {

        for (int i = 0; i < n; i++) {//列
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {//左对角线
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {//右对角线
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private static List<String> array2List(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            String s = String.copyValueOf(c);
            list.add(s);
        }
        return list;
    }

}
