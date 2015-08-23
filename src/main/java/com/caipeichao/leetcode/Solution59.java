package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/19.
 */
public class Solution59 {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int UP = 2;
    private static final int DOWN = 3;

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int n2 = n * n;
        int direction = DOWN;
        Point current = new Point();
        for (int i = 1; i <= n2; i++) {
            result[current.x][current.y] = i;
            Point afterMove = move(current, direction);
            if (!validatePoint(result, afterMove)) {
                direction = turnLeft(direction);
                afterMove = move(current, direction);
            }
            current = afterMove;
        }
        return result;
    }

    private boolean validatePoint(int[][] result, Point p) {
        if (p.x < 0) return false;
        if (p.y < 0) return false;
        int n = result.length;
        if (p.x >= n) return false;
        if (p.y >= n) return false;
        if (result[p.x][p.y] != 0) return false;
        return true;
    }

    private int turnRight(int direction) {
        switch (direction) {
            case LEFT:
                return UP;
            case UP:
                return RIGHT;
            case RIGHT:
                return DOWN;
            case DOWN:
                return LEFT;
            default:
                throw new RuntimeException();
        }
    }

    private int turnLeft(int direction) {
        switch (direction) {
            case LEFT:
                return DOWN;
            case DOWN:
                return RIGHT;
            case RIGHT:
                return UP;
            case UP:
                return LEFT;
            default:
                throw new RuntimeException();
        }
    }

    private static class Point {
        public int x;
        public int y;

        public Point() {

        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point move(Point p, int direction) {
        switch (direction) {
            case LEFT:
                return new Point(p.x - 1, p.y);
            case RIGHT:
                return new Point(p.x + 1, p.y);
            case UP:
                return new Point(p.x, p.y - 1);
            case DOWN:
                return new Point(p.x, p.y + 1);
            default:
                throw new RuntimeException();
        }
    }
}
