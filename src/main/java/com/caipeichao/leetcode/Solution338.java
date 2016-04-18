package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 16/4/18.
 */
public class Solution338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        if (num >= 0) result[0] = 0;
        if (num >= 1) result[1] = 1;
        for (int i = 2; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}

