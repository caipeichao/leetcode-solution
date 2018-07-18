package com.caipeichao.leetcode;

public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) return true;
        int point = findFirstDecreasingPoint(nums);
        if (point < 0) return true;
        if (replaceAndTestNonDecreasing(nums, point, nums[point + 1])) return true;
        if (replaceAndTestNonDecreasing(nums, point + 1, nums[point])) return true;
        return false;
    }

    private int findFirstDecreasingPoint(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    private boolean replaceAndTestNonDecreasing(int[] nums, int pos, int value) {
        int backup = nums[pos];
        nums[pos] = value;
        boolean result = isNonDecreasing(nums);
        nums[pos] = backup;
        return result;
    }

    private boolean isNonDecreasing(int[] nums) {
        return findFirstDecreasingPoint(nums) < 0;
    }
}
