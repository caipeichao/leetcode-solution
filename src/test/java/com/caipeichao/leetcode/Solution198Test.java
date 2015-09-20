package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution198Test {

    @Test
    public void testRob() throws Exception {
        int result = new Solution198().rob(TestUtils.parseIntArray("1,2,3,4,5,6"));
        assertEquals(result, 12);
    }
}