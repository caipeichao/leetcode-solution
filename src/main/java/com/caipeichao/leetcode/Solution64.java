package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/17.
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        // 获取长度和宽度，没有长度宽度就直接返回了
        int width = grid.length;
        if (width == 0) return 0;
        int height = grid[0].length;
        if (height == 0) return 0;

        // 计算从起点到各个点的最小路径和。
        int[][] min = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // 获取当前格子上面格子的值，并处理边界值
                int top;
                if (y == 0) {
                    top = Integer.MAX_VALUE;
                } else {
                    top = min[x][y - 1];
                }

                // 获取当前格子左边的值，并处理边界值
                int left;
                if (x == 0) {
                    left = Integer.MAX_VALUE;
                } else {
                    left = min[x - 1][y];
                }

                // 上面和左边都没有格子，那就是起点，从0开始计算
                int topLeftMin = Math.min(top, left);
                if (topLeftMin == Integer.MAX_VALUE) {
                    topLeftMin = 0;
                }

                // 取左边格子的最短路径和上面格子的最短路径，加上当前格子的值
                // 就是起点到当前格子的最短路径
                min[x][y] = topLeftMin + grid[x][y];
            }
        }
        return min[width - 1][height - 1];
    }
}
