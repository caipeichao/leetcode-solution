package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution162Test {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 1};
        int actual = new Solution162().findPeakElement(nums);
        assertEquals(actual, 1);

        nums = new int[]{1, 2, 3, 2, 1};
        actual = new Solution162().findPeakElement(nums);
        assertEquals(actual, 2);

        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8};
        actual = new Solution162().findPeakElement(nums);
        assertEquals(actual, 8);
    }
}