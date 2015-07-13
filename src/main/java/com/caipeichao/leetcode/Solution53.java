package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/7/9.
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = nums[0];
        int currentStart = 0;
        for (int i = 1; i < nums.length; i++) {
            currentSum += nums[i];
        }
        if(currentSum > maxSum) {
            return currentSum;
        }
        return maxSum;
    }
}
