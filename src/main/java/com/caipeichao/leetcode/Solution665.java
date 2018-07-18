package com.caipeichao.leetcode;

public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 2) return true;
        boolean modifyChance = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) continue;
            if (!modifyChance) return false;
            modifyChance = false;
        }
        return true;
    }
}
