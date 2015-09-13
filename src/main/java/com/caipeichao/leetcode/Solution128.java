package com.caipeichao.leetcode;

import java.util.Arrays;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int result = 1;
        int startI = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                // 是连续的
                if (startI == -1) {
                    startI = i - 1;
                }
            } else if (nums[i - 1] == nums[i]) {
                if (startI != -1) {
                    startI++;
                }
            } else {
                // 不是连续的
                if (startI != -1) {
                    int endI = i;
                    int consequentiveLength = endI - startI;
                    result = Math.max(result, consequentiveLength);
                    startI = -1;
                }
            }
        }
        if (startI != -1) {
            int endI = nums.length;
            int consequentiveLength = endI - startI;
            result = Math.max(result, consequentiveLength);
        }
        return result;
    }
}
