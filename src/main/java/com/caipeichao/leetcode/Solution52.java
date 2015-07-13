package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/6/23.
 */
public class Solution52 {
    public int totalNQueens(int n) {
        Board board = new Board(n);
        int result = 0;
        for (int i = 0; i < n; i++) {
            Board board2 = board.cloneBoard();
            board2.putQueen(i, 0);
            result += totalNQueens(board2, n - 1);
        }
        return result;
    }

    private int totalNQueens(Board board, int remainQueen) {
        if (remainQueen == 0) return 1;
        int result = 0;
        for (int x = 0; x < board.getSize(); x++) {
            for (int y = 0; y < board.getSize(); y++) {
                if (!board.isAvailable(x, y)) continue;
                board.setInvalid(x, y);
                Board board2 = board.cloneBoard();
                board2.putQueen(x, y);
                if (remainQueen > 1) {
                    result += totalNQueens(board2, remainQueen - 1);
                } else {
                    // System.out.println(board2.toString());
                    result += 1;
                }
            }
        }
        return result;
    }

    private static class Board {
        private int size;
        private boolean[] invalid;
        private boolean[] cheese;

        public Board(int size) {
            this.size = size;
            this.invalid = new boolean[size * size];
            this.cheese = new boolean[size * size];
        }

        public void putQueen(int x, int y) {
            setCheese(x, y);
            for (int i = 0; i < size; i++) {
                setInvalid(x, i);
                setInvalid(i, y);
            }
            for (int i = 1; x + i < size && y - i >= 0; i++) {
                setInvalid(x + i, y - i);
            }
            for (int i = 1; x + i < size && y + i < size; i++) {
                setInvalid(x + i, y + i);
            }
            for (int i = 1; x - i >= 0 && y + i < size; i++) {
                setInvalid(x - i, y + i);
            }
            for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
                setInvalid(x - i, y - i);
            }
        }

        private void setInvalid(int x, int y) {
            invalid[x + y * size] = true;
        }

        private void setCheese(int x, int y) {
            cheese[x + y * size] = true;
        }

        public boolean isAvailable(int x, int y) {
            return !invalid[x + y * size];
        }

        public boolean isCheese(int x, int y) {
            return cheese[x + y * size];
        }

        public Board cloneBoard() {
            Board that = new Board(size);
            System.arraycopy(this.invalid, 0, that.invalid, 0, that.invalid.length);
            System.arraycopy(this.cheese, 0, that.cheese, 0, that.cheese.length);
            return that;
        }

        public int getSize() {
            return size;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {
                    if (isCheese(x, y)) {
                        result.append("* ");
                    } else if (isAvailable(x, y)) {
                        result.append("  ");
                    } else {
                        result.append(". ");
                    }
                }
                result.append("\n");
            }
            return result.toString();
        }
    }
}
