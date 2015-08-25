package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/25.
 */
public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int tail = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == val) {
                swap(nums, i, tail);
                tail--;
            }
        }
        return tail + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
