package com.caipeichao.leetcode;

public class Solution268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        for (int e : nums) sum -= e;
        return sum;
    }
}

