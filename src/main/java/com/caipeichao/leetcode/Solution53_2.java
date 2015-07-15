package com.caipeichao.leetcode;

public class Solution53_2 {
    public int maxSubArray(int[] nums) {
        // 从前到后积累，找最大值
        int sum1 = 0;
        int maxSum1 = Integer.MIN_VALUE;
        int maxIndex1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            if (maxSum1 < sum1) {
                maxIndex1 = i;
                maxSum1 = sum1;
            }
        }

        // 从后到前积累，找最大值
        int sum2 = 0;
        int maxSum2 = Integer.MIN_VALUE;
        int maxIndex2 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum2 += nums[i];
            if (maxSum2 < sum2) {
                maxIndex2 = i;
                maxSum2 = sum2;
            }
        }

        // 两个区间进行求和
        int sum3 = 0;
        int start = 0;
        int end = 0;
        if(maxIndex1 < maxIndex2) {
            start = maxIndex1;
            end = maxIndex2;
        } else {
            start = maxIndex2;
            end = maxIndex1;
        }
        for (int i = start; i <= end; i++) {
            sum3 += nums[i];
        }
        return sum3;
    }
}
