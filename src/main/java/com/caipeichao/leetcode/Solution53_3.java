package com.caipeichao.leetcode;

public class Solution53_3 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int lastMovingSum = 0;
        int lastMovingMin = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int movingSum = lastMovingSum + nums[i];
            int movingMin;
            if (lastMovingMin > movingSum) {
                movingMin = lastMovingSum;
            } else {
                movingMin = lastMovingMin;
            }
            int sum = movingSum - movingMin;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}

