package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/31.
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 将矩阵映射为一个线性数组
        VirtualArray array = new VirtualArray(matrix);

        // 用二分查找寻找指定的值
        int size = array.size();
        if (size == 0) return false;
        if (target < array.get(0)) return false;
        if (target > array.get(size - 1)) return false;

        // 二分查找
        int start = 0;
        int end = size;
        while (true) {
            // 二分范围已经缩小到只剩一个了，判断这一个与target是否相等
            if (end - start == 1) {
                if (array.get(start) == target) {
                    return true;
                } else {
                    return false;
                }
            }

            // 二分范围已经没有了，说明找不到了
            if (end - start == 0) return false;

            // 取中间的数，然后缩小一半范围
            int mid = (end - start - 1) / 2 + start;
            int test = array.get(mid);
            if (target > test) {
                start = mid + 1;
            } else if (target < test) {
                end = mid;
            } else {
                return true;
            }
        }
    }

    private static class VirtualArray {
        private int[][] matrix;
        private int width;
        private int height;

        public VirtualArray(int[][] matrix) {
            this.matrix = matrix;
            this.width = matrix.length;
            this.height = matrix[0].length;
        }

        public int size() {
            if (matrix.length == 0) return 0;
            return matrix.length * matrix[0].length;
        }

        public int get(int index) {
            int x = index / height;
            int y = index % height;
            return matrix[x][y];
        }
    }
}
