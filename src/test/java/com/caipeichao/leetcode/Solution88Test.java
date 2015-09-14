package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution88Test {

    @Test
    public void testMerge() throws Exception {
        int[] a = new int[]{2, 6, 9, 0, 0, 0, 0};
        int[] b = new int[]{1, 3, 4, 5};
        new Solution88().merge(a, 3, b, 4);
        assertEquals(TestUtils.toString(a), "1234569");
    }
}