package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 获取长度和宽度
        int width = matrix.length;
        if (width == 0) return false;
        int height = matrix[0].length;
        if (height == 0) return false;

        // 将较长的一层作为二分查找
        VirtualMatrix m;
        if (width > height) {
            m = new VirtualMatrix(matrix);
        } else {
            m = new ReverseMatrix(matrix);
        }

        // 分层二分查找
        for (int y = 0; y < m.getHeight(); y++) {
            boolean found = bisect(m, y, target);
            if (found) return true;
        }
        return false;
    }

    private boolean bisect(VirtualMatrix matrix, int y, int target) {
        int start = 0;
        int end = matrix.getWidth();
        int startNum = matrix.get(start, y);
        int endNum = matrix.get(end - 1, y);
        if (target < startNum) return false;
        if (target > endNum) return false;
        while (true) {
            int length = end - start;
            if (length < 5) {
                for (int i = start; i < end; i++) {
                    if (matrix.get(i, y) == target)
                        return true;
                }
                return false;
            }
            int mid = start + (length - 1) / 2;
            int midNum = matrix.get(mid, y);
            if (midNum == target) {
                return true;
            } else if (midNum < target) {
                start = mid;
            } else {
                end = mid + 1;
            }
        }
    }

    public static class VirtualMatrix {
        private int[][] matrix;
        private int width;
        private int height;

        public VirtualMatrix(int[][] matrix) {
            this.matrix = matrix;
            this.width = matrix.length;
            this.height = matrix[0].length;
        }

        public int get(int x, int y) {
            return matrix[x][y];
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

    public static class ReverseMatrix extends VirtualMatrix {
        public ReverseMatrix(int[][] matrix) {
            super(matrix);
        }

        @Override
        public int get(int x, int y) {
            return super.get(y, x);
        }

        @Override
        public int getWidth() {
            return super.getHeight();
        }

        @Override
        public int getHeight() {
            return super.getWidth();
        }
    }
}
