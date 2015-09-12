package com.caipeichao.leetcode;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            nums[j++] = nums[i];
        }
        return j;
    }
}
