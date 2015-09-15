package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution33 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        // 二分查找，找出分界点
        int splitIndex = findSplit(nums);
        if (splitIndex == -1) splitIndex = 0;

        // 虚拟一个数组，然后使用二分查找
        VirtualArray array = new VirtualArray(nums, splitIndex);
        int virtualPos = bisection(array, target);
        if (virtualPos == -1) return -1;
        return array.mapIndex(virtualPos);
    }

    private int bisection(VirtualArray array, int target) {
        // 二分查找
        int start = 0;
        int end = array.length();
        while (true) {
            // 如果确定的范围已经很小了，那就不用递归了，直接一个循环搞定
            int length = end - start;
            if (length < 5) {
                for (int i = start; i < end; i++) {
                    if (array.get(i) == target) {
                        return i;
                    }
                }
                return -1;
            }

            // 缩小搜索范围
            int mid = start + (length - 1) / 2;
            int midNum = array.get(mid);
            if (midNum < target) {
                start = mid;
            } else if (midNum > target) {
                end = mid + 1;
            } else {
                return mid;
            }
        }
    }

    private static class VirtualArray {
        private int[] nums;
        private int startIndex;

        public VirtualArray(int[] nums, int startIndex) {
            this.nums = nums;
            this.startIndex = startIndex;
        }

        public int length() {
            return nums.length;
        }

        public int get(int i) {
            return nums[mapIndex(i)];
        }

        public int mapIndex(int i) {
            return (i + startIndex) % nums.length;
        }
    }

    public int findSplit(int[] nums) {
        return findSplit(nums, 0, nums.length);
    }

    private int findSplit(int[] nums, int start, int end) {
        // 如果长度很小，就不递归了
        int length = end - start;
        if (length < 5) {
            for (int i = start + 1; i < end; i++) {
                if (nums[i - 1] > nums[i]) {
                    return i;
                }
            }
            return -1;
        }

        // 二分查找
        int mid = start + (length - 1) / 2;
        int startNum = nums[start];
        int midNum = nums[mid];
        if (startNum > midNum) {
            return findSplit(nums, start, mid + 1);
        } else {
            return findSplit(nums, mid, end);
        }
    }
}

