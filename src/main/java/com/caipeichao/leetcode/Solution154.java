package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/18.
 */
public class Solution154 {
    public int findMin(int[] nums) {
        if (nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int e : nums) {
            min = Math.min(e, min);
        }
        return min;
    }
}