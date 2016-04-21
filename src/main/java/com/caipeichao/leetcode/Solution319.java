package com.caipeichao.leetcode;

public class Solution319 {
    public int bulbSwitch(int n) {
        boolean[] result = new boolean[n];
        for (int i = 1; i <= n; i++) {
            for (int j = i-1; j < n; j += i) {
                result[j] = !result[j];
            }
        }
        return count(result);
    }

    private int count(boolean[] a) {
        int result = 0;
        for (boolean e : a)
            if (e) result++;
        return result;
    }
}