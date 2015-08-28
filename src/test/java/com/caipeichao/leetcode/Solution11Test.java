package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution11Test {

    @Test
    public void testMaxArea() throws Exception {
        Solution11 s = new Solution11();
        int result = s.maxArea(new int[]{1, 2, 3, 4, 5});
        assertEquals(result, 6);
    }
}