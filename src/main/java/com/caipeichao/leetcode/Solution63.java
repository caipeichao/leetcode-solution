package com.caipeichao.leetcode;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 获取地图的长度和高度
        int width = obstacleGrid.length;
        int height = obstacleGrid[0].length;

        // 储存路径条数
        int[][] pathCount = new int[width][height];

        // 先从最左下角开始，每个格子计算路径数量
        for (int x = width - 1; x >= 0; x--) {
            for (int y = height - 1; y >= 0; y--) {
                if (obstacleGrid[x][y] == 1) {
                    pathCount[x][y] = 0;
                    continue;
                }
                if (x == width - 1 && y == height - 1) {
                    pathCount[x][y] = 1;
                    continue;
                }
                pathCount[x][y] = get(pathCount, x + 1, y) + get(pathCount, x, y + 1);
            }
        }

        // 最终结果
        return pathCount[0][0];
    }

    public int get(int[][] pathCount, int x, int y) {
        if (x >= pathCount.length) return 0;
        if (y >= pathCount[x].length) return 0;
        return pathCount[x][y];
    }
}
