package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution120Test {

    @Test
    public void testMinimumTotal() throws Exception {
        List<List<Integer>> lists = TestUtils.parseJsonListList("[\n" +
                "     [2],\n" +
                "    [3,4],\n" +
                "   [6,5,7],\n" +
                "  [4,1,8,3]\n" +
                "]");
        int result =  new Solution120().minimumTotal(lists);
        assertEquals(result, 11);
    }
}