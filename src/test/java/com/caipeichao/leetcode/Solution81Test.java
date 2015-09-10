package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution81Test {

    @Test(dataProvider = "a")
    public void testFindSplitPoint(int[] nums, int expect) throws Exception {
        int result = new Solution81().findSplitPoint(nums);
        assertEquals(result, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provideFindSplitPoint() {
        return new Object[][]{
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 3},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3, 4}, 3},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3, 4, 5}, 3},
                new Object[]{new int[]{1}, -1},
                new Object[]{new int[]{1, 2}, -1},
                new Object[]{new int[]{1, 2, 3}, -1},
                new Object[]{new int[]{1, 2, 3, 4}, -1},
                new Object[]{new int[]{1, 2, 3, 4, 5}, -1},
                new Object[]{new int[]{1, 2, 3, 4, 5, 6}, -1},
                new Object[]{new int[]{1, 2, 3, 4, 5, 6, 7}, -1},
                new Object[]{new int[]{1, 2, 3, 4, 5, 6, 7, 8}, -1},
                new Object[]{new int[]{1}, -1},
                new Object[]{new int[]{1, 1}, -1},
                new Object[]{new int[]{1, 1, 1}, -1},
                new Object[]{new int[]{1, 1, 1, 1}, -1},
                new Object[]{new int[]{1, 1, 1, 1, 1}, -1},
                new Object[]{new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, -1},
                new Object[]{new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1}, 15},
        };
    }

    @Test(dataProvider = "s")
    public void testS(int[] nums, int target, boolean expect) throws Exception {
        boolean result = new Solution81().search(nums, target);
        assertEquals(result, expect);
    }

    @DataProvider(name = "s")
    public Object[][] provideSearch() {
        return new Object[][]{
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 0, false},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 1, true},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 2, true},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 3, true},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 4, false},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 5, true},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 6, true},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 7, true},
                new Object[]{new int[]{5, 6, 7, 1, 2, 3}, 8, false},
                new Object[]{new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}, 8, false},
                new Object[]{new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}, 1, true},
        };
    }
}