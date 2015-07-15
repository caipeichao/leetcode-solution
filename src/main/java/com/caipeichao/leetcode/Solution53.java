package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/7/9.
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxSum = -999999;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maxSum) maxSum = sum;
            }
        }
        return maxSum;
    }
}

