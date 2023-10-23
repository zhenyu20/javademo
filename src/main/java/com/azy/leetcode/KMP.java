package com.azy.leetcode;

import java.util.Arrays;
/**
 * <p>2023-10-18 13:06:11</p>
 */
public class KMP {
    private static int cnt = 0;
    public static void main(String[] args) {
        System.out.println(kmp("ahah-ah-a-hah", "ah-a-")); // Output: 5
        System.out.println(cnt);
    }

    private static int[] getNext(String p) {
        int n = p.length(), k = -1, j = 0;
        int[] next = new int[n];
        Arrays.fill(next,-1);
        while (j < n - 1) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                ++k; ++j;
                next[j] = (p.charAt(j) != p.charAt(k)) ? k : next[k];
            } else {
                k = next[k];
            }
        }
        return next;
    }

    private static int kmp(String s, String p) {
        int m = s.length(), n = p.length(), i = 0, j = 0;
        int[] next= getNext(p);
        while (i < m && j < n) {
            if (j == - 1 || s.charAt(i) == p.charAt(j)) {
                ++i; ++j;
            } else {
                j = next[j];
                cnt++;
            }
        }
        return (j == n) ? i - j : -1;
    }
}
