package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/6/25.
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (nums[0] == target) return 0;
        int begin = 0;
        int end = nums.length;
        while (begin < end) {
            int mid = (int) (((long) begin + end) / 2);
            int num = nums[mid];
            if (num < target) {
                begin = mid + 1;
            } else if (num > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        return begin;
    }
}
