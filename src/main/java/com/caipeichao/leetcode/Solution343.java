package com.caipeichao.leetcode;

public class Solution343 {
    public int integerBreak(int n) {
        int[] cache = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int maxMulti = 0;
            for (int j = 1; j <= i; j++) {
                int k = i - j;
                maxMulti = Math.max(maxMulti, k * cache[j]);
            }
            if (i == n) return maxMulti;
            cache[i] = Math.max(maxMulti, i);
        }
        throw new RuntimeException("x");
    }
}
