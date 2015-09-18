package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution39Test {

    @Test
    public void testCombinationSum() throws Exception {
        int[] a = new int[]{2, 3, 6, 7};
        List<List<Integer>> r = new Solution39().combinationSum(a, 7);
        assertEquals(TestUtils.toString(r), "223,7");
    }
}