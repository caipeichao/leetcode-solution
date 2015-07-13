package com.caipeichao.leetcode;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution35Test {
    private Solution35 solution;

    @BeforeMethod
    public void init() {
        solution = new Solution35();
    }

    @Test(dataProvider = "s")
    public void testSearchInsert(int[] nums, int target, int expect) throws Exception {
        assertEquals(solution.searchInsert(nums, target), expect);
    }

    @DataProvider(name = "s")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{new int[]{1, 2, 3}, 1, 0},
                new Object[]{new int[]{1, 2, 3}, 2, 1},
                new Object[]{new int[]{1, 2, 3}, 3, 2},
                new Object[]{new int[]{1, 2, 3}, 4, 3},
                new Object[]{new int[]{1, 2, 3}, 0, 0},
                new Object[]{new int[]{1, 2, 3, 5, 6}, 4, 3},
        };
    }
}