package com.caipeichao.leetcode;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        if (!check3x3(board)) return false;
        if (!checkLine(board)) return false;
        return true;
    }

    private boolean check3x3(char[][] board) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (!check3x3(board, x * 3, y * 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check3x3(char[][] board, int x, int y) {
        Checker checker = new Checker();
        for (int ix = 0; ix < 3; ix++) {
            for (int iy = 0; iy < 3; iy++) {
                if (!checker.add(board[ix + x][iy + y])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkLine(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkVerticle(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!checkHorizon(board, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkVerticle(char[][] board, int x) {
        Checker checker = new Checker();
        for (int y = 0; y < 9; y++) {
            if (!checker.add(board[x][y])) {
                return false;
            }
        }
        return true;
    }

    private boolean checkHorizon(char[][] board, int y) {
        Checker checker = new Checker();
        for (int x = 0; x < 9; x++) {
            if (!checker.add(board[x][y])) {
                return false;
            }
        }
        return true;
    }

    public static class Checker {
        private boolean[] bit = new boolean[9];

        public boolean add(char x) {
            if (x == '.') return true;
            int i = x - '1';
            if (bit[i]) return false;
            bit[i] = true;
            return true;
        }
    }
}
