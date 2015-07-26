package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/7/26.
 */
public class Solution153 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length);
    }

    private int findMin(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return arrayGet(nums, end);
        }

        int mid = (start + end) / 2;
        int startValue = arrayGet(nums, start);
        int midValue = arrayGet(nums, mid);
        int endValue = arrayGet(nums, end);
        if (startValue > midValue) {
            return findMin(nums, start, mid);
        } else if (endValue < midValue) {
            return findMin(nums, mid, end);
        } else {
            throw new RuntimeException("Not found min");
        }
    }

    private int arrayGet(int[] nums, int i) {
        return nums[i % nums.length];
    }
}
