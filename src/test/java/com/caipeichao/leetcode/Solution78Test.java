package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution78Test {

    @Test
    public void testSubsets() throws Exception {
        int[] a=TestUtils.parseIntArray("1,3,5,8,9");
        List<List<Integer>> actual = new Solution78().subsets(a);
        String actual2 = TestUtils.toString(actual);
        assertEquals(actual2, ",1,3,5,8,9,13,15,18,19,135,138,139,1358,1359,13589,");
    }
}