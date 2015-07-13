package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/7/9.
 */
public class Solution70 {
    private static final int[] answer = buildAnswer();

    public int climbStairs(int n) {
        return answer[n];
    }

    private static int[] buildAnswer() {
        int[] result = new int[100];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result;
    }
}
