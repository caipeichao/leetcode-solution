package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution279Test {

    @Test(dataProvider = "a")
    public void testNumSquares(int input, int expect) throws Exception {
        int actual = new Solution279().numSquares(input);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{12, 3},
                new Object[]{0, 0},
                new Object[]{1, 1},
                new Object[]{2, 2},
                new Object[]{3, 3},
                new Object[]{4, 1},
                new Object[]{5, 2},
                new Object[]{6, 3},
                new Object[]{7, 4},
                new Object[]{123456, 3},
        };
    }
}