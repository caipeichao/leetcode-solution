package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution53Test {
    @Test
    public void test() {
        Solution53_3 a = new Solution53_3();
        int result = a.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(result, 6);
    }

    @Test
    public void test2() {
        Solution53_3 a = new Solution53_3();
        int result = a.maxSubArray(new int[]{123});
        assertEquals(result, 123);
    }

    @Test
    public void test3() {
        Solution53_3 a = new Solution53_3();
        int result = a.maxSubArray(new int[]{-2, -1});
        assertEquals(result, -1);
    }
}