package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution172Test {

    @Test
    public void testTrailingZeroes() throws Exception {
        int actual = new Solution172().trailingZeroes(1000000);
        assertEquals(actual, 249998);
    }
}