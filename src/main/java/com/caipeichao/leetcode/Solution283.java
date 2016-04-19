package com.caipeichao.leetcode;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (true) {
            while (start < nums.length && nums[start] != 0) start++;
            while (end >= 0 && nums[end] == 0) end--;
            if (start >= end) break;
            swap(nums, start, end);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
