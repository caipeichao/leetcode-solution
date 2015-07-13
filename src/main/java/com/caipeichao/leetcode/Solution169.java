package com.caipeichao.leetcode;

import java.util.Arrays;

/**
 * Created by caipeichao on 15/7/5.
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
