package com.caipeichao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution73 {
    public void setZeroes(int[][] matrix) {
        // 获取长度和宽度
        int width = matrix.length;
        if (width == 0) return;
        int height = matrix[0].length;
        if (height == 0) return;

        // 找出需要归零的x坐标和y坐标
        Set<Integer> zeroX = new HashSet<Integer>();
        Set<Integer> zeroY = new HashSet<Integer>();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (matrix[x][y] == 0) {
                    zeroX.add(x);
                    zeroY.add(y);
                }
            }
        }

        // 执行归零
        for (Integer x : zeroX) {
            for (int y = 0; y < height; y++) {
                matrix[x][y] = 0;
            }
        }
        for (Integer y : zeroY) {
            for (int x = 0; x < width; x++) {
                matrix[x][y] = 0;
            }
        }
    }
}
