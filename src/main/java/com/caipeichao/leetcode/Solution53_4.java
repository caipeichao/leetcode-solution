package com.caipeichao.leetcode;

public class Solution53_4 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) sum = 0;
            maxSum = Math.max(maxSum, sum);
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (maxNum < 0) return maxNum;
        return maxSum;
    }
}
