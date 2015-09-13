package com.caipeichao.leetcode;

public class Solution172 {
    public int trailingZeroes(int n) {
        // 统计质因素2出现的次数
        int count2 = 0;
        for (int x = 2; x <= n; x++) {
            count2 += countPrime(x, 2);
        }

        // 统计5出现的次数
        int count5 = 0;
        for (int x = 5; x <= n; x++) {
            count5 += countPrime(x, 5);
        }

        // 末尾0出现的次数
        return Math.min(count2, count5);
    }

    private int countPrime(int x, int n) {
        int result = 0;
        while (true) {
            if (x % n != 0) return result;
            result++;
            x = x / n;
        }
    }
}
