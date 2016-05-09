package com.caipeichao.leetcode;

public class Solution289 {
    private int width = 0;
    private int height = 0;
    private int[][] board;

    public void gameOfLife(int[][] board) {
        // 全局变量
        this.width = board.length;
        this.height = board[0].length;
        this.board = board;

        // 统计每个点上的细胞数量
        int[][] count = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int c = 0;
                c += get(x - 1, y - 1);
                c += get(x - 1, y);
                c += get(x - 1, y + 1);
                c += get(x, y - 1);
                c += get(x, y + 1);
                c += get(x + 1, y - 1);
                c += get(x + 1, y);
                c += get(x + 1, y + 1);
                count[x][y] = c;
            }
        }

        // 生命游戏规则
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int c = count[x][y];
                if (c == 3) board[x][y] = 1;
                else if (c == 2) board[x][y] = board[x][y];
                else board[x][y] = 0;
            }
        }
    }

    private int get(int x, int y) {
        if (x < 0) x += width;
        if (y < 0) y += height;
        if (x >= width) x -= width;
        if (y >= height) y -= height;
        return board[x][y];
    }
}
