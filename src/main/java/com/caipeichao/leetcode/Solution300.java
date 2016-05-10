package com.caipeichao.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        for (int i = 0; i < n; i++) len[i] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                len[i] = Math.max(len[i], len[j] + 1);
            }
        }
        int max = 0;
        for (int e : len) max = Math.max(max, e);
        return max;
    }
}

