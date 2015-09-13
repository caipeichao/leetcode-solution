package com.caipeichao.leetcode;

import java.util.LinkedList;

public class Solution66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;

            // 符合条件了，可以退出了
            if (digits[i] < 10) {
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = 0;
        }
        return result;
    }
}

