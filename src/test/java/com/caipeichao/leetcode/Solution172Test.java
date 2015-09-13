package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution172Test {

    @Test
    public void testTrailingZeroes() throws Exception {
        for (int i = 0; i < 1000; i++) {
            int actual = new Solution172().trailingZeroes(i);
            System.out.println(i + "," + actual);
        }
        // assertEquals(actual, 249998);
    }
}