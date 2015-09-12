package com.caipeichao.leetcode;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int lastLast = 0;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 2 && lastLast == nums[i]) {
                continue;
            }
            nums[j++] = nums[i];
            lastLast = last;
            last = nums[i];
        }
        return j;
    }
}

