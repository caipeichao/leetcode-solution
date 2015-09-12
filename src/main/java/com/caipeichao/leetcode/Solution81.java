package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        // 如果长度很小，就扫描查找就行了
        if (nums.length < 5) {
            for (int e : nums) {
                if (e == target) return true;
            }
            return false;
        }

        // 找出分界点
        int splitPoint = findSplitPoint(nums);
        if (splitPoint == -1) {
            splitPoint = 0;
        }

        // 二分查找
        ShiftIntArray array = new ShiftIntArray(nums, splitPoint);
        return binarySearch(array, target);
    }

    public boolean binarySearch(ShiftIntArray array, int target) {
        int start = 0;
        int end = array.size();
        while (true) {
            // 数量少，只要顺序扫描就行了
            int length = end - start;
            if (length < 5) {
                for (int i = 0; i < array.size(); i++) {
                    if (array.get(i) == target) {
                        return true;
                    }
                }
                return false;
            }

            // 数量多，二分查找
            int mid = start + (length - 1) / 2;
            int midNumber = array.get(mid);
            if (midNumber < target) {
                start = mid + 1;
                continue;
            }
            if (target < midNumber) {
                end = mid;
                continue;
            }
            if (target == midNumber) {
                return true;
            }
        }
    }

    public int findSplitPoint(int[] nums) {
        return findSplitPoint(nums, 0, nums.length);
    }

    public int findSplitPoint(int[] nums, int start, int end) {
        // 特殊情况
        int length = end - start;
        if (length == 0) return -1;
        if (length == 1) return -1;
        if (length == 2) {
            if (nums[start] > nums[start + 1]) return start + 1;
            if (nums[start] < nums[start + 1]) return -1;
            return -1;
        }

        // 有三个点以上
        int mid = start + (length - 1) / 2;
        int startNumber = nums[start];
        int midNumber = nums[mid];
        int endNumber = nums[end - 1];

        //
        if (startNumber > midNumber) {
            return findSplitPoint(nums, start, mid + 1);
        }

        if (midNumber > endNumber) {
            return findSplitPoint(nums, mid, end);
        }

        if (startNumber == midNumber) {
            int result = findSplitPoint(nums, start, mid + 1);
            if (result != -1) return result;
        }

        if (midNumber == endNumber) {
            int result = findSplitPoint(nums, mid, end);
            if (result != -1) return result;
        }

        return -1;
    }

    private static class ShiftIntArray {
        private int[] nums;
        private int start;

        public ShiftIntArray(int[] nums, int start) {
            this.nums = nums;
            this.start = start;
        }

        public int size() {
            return nums.length;
        }

        public int get(int i) {
            return nums[(start + i) % nums.length];
        }
    }
}

