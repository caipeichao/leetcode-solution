package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/7/26.
 */
public class Solution62 {
    private static int[][] answer = buildAnswer();

    public int uniquePaths(int m, int n) {
        return getAnswer(answer, m, n);
    }

    private static int[][] buildAnswer() {
        int[][] result = new int[101][101];
        result[1][1] = 0;
        result[1][2] = 1;
        result[1][3] = 1;
        result[2][2] = result[1][2] + result[1][2];
        result[2][3] = result[1][3] + result[2][2];
        result[3][3] = result[2][3] + result[2][3];

        for (int i = 0; i < result.length; i++) {
            result[1][i] = 1;
        }

        for (int m = 4; m < 101; m++) {
            for (int n = 2; n <= m; n++) {
                result[n][m] = getAnswer(result, n - 1, m) + getAnswer(result, n, m - 1);
            }
        }

        return result;
    }

    private static int getAnswer(int[][] result, int m, int n) {
        if (m > n) return result[n][m];
        return result[m][n];
    }
}
