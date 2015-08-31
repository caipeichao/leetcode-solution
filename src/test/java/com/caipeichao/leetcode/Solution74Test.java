package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution74Test {

    @Test(dataProvider = "search")
    public void testSearchMatrix(int target, boolean expect) throws Exception {
        int[][] m = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50},
        };
        Solution74 s = new Solution74();
        boolean actual = s.searchMatrix(m, target);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "search")
    public Object[][] provideSearch() {
        return new Object[][]{
                new Object[]{1, true},
                new Object[]{2, false},
                new Object[]{3, true},
                new Object[]{4, false},
                new Object[]{5, true},
                new Object[]{6, false},
                new Object[]{7, true},
                new Object[]{8, false},
                new Object[]{9, false},
                new Object[]{10, true},
                new Object[]{11, true},
                new Object[]{12, false},
                new Object[]{13, false},
                new Object[]{14, false},
                new Object[]{15, false},
                new Object[]{20, true},
        };
    }
}