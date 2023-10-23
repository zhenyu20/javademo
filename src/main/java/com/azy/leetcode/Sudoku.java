package com.azy.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[9][9];
        backtracking(board);
    }

    private static boolean backtracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char k = '0'; k < '9'; k++) {
                    if (isValid(board, k, i, j)) {
                        board[i][j] = k;
                        if (backtracking(board))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, char k, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == k) return false;
        }
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == k) return false;
        }
        int r = row / 3 * 3, c = col / 3 * 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == k) return false;
            }
        }
        return true;
    }

}
