package com.caipeichao.leetcode;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        // 0到i-1乘积
        int[] p1 = new int[nums.length + 1];
        p1[0] = 1;
        p1[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            p1[i] = p1[i - 1] * nums[i - 1];
        }

        // i到末尾乘积
        int[] p2 = new int[nums.length + 1];
        p2[nums.length] = 1;
        p2[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            p2[i] = p2[i + 1] * nums[i];
        }

        // 计算各个乘积
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = p1[i] * p2[i + 1];
        }
        return result;
    }
}
