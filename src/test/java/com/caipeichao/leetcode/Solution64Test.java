package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution64Test {
    @Test
    public void test() {
        int[][] grid = new int[][]{
                new int[]{1,2},
                new int[]{1,1},
        };
        int result = new Solution64().minPathSum(grid);
        assertEquals(result, 3);
    }
}