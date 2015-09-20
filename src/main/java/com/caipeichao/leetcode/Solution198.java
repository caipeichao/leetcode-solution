package com.caipeichao.leetcode;

import java.util.Arrays;

public class Solution198 {
    public int rob(int[] nums) {
        int last1Max = 0;
        int last2Max = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentMax = Math.max(last2Max + nums[i], last1Max);
            last2Max = last1Max;
            last1Max = currentMax;
        }
        return last1Max;
    }
}
