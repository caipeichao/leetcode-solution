package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution128Test {

    @Test
    public void testLongestConsecutive() throws Exception {
        int actual = new Solution128().longestConsecutive(new int[]{5, 3, 4, 6, 7, 1});
        assertEquals(actual, 5);

        actual = new Solution128().longestConsecutive(new int[]{5, 3, 3, 4, 6, 7, 1});
        assertEquals(actual, 5);
    }
}