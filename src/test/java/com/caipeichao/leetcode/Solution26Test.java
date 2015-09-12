package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution26Test {

    @Test
    public void testRemoveDuplicates() throws Exception {
        int[] nums = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5};
        int actualLength = new Solution26().removeDuplicates(nums);
        assertEquals(actualLength, 5);
        assertEquals(toString(nums), "123452222345555");
    }

    private String toString(int[] nums) {
        StringBuilder result = new StringBuilder();
        for (int e : nums) {
            result.append(e);
        }
        return result.toString();
    }
}