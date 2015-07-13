package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/6/22.
 */
public class Solution96 {
    public static int[] answer = buildAnswer();

    public int numTrees(int n) {
        return answer[n];
    }

    private static int[] buildAnswer() {
        int[] result = new int[32];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i < result.length; i++) {
            for (int left = 0; left < i; left++) {
                int right = i - 1 - left;
                result[i] += result[left] * result[right];
            }
        }
        return result;
    }
}
