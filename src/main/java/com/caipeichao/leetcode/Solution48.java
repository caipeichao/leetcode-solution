package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/18.
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        // 复制一份原始数据
        int n = matrix.length;
        int[][] original = new int[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                original[x][y] = matrix[x][y];
            }
        }

        // 利用公式返回结果
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                matrix[x][y] = original[n - 1 - y][x];
            }
        }
    }
}
