package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution53Test {
    private Solution53_4 a = new Solution53_4();

    @Test
    public void test() {
        int result = a.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(result, 6);
    }

    @Test
    public void test2() {
        int result = a.maxSubArray(new int[]{123});
        assertEquals(result, 123);
    }

    @Test
    public void test3() {
        int result = a.maxSubArray(new int[]{-2, -1});
        assertEquals(result, -1);
    }
}

// n   : -2 -1
// sum : -2 -3
// max : -2
// min0: -2 -3
// min1:  0 -2
// sum : -2 -1
// msum: -2 -1