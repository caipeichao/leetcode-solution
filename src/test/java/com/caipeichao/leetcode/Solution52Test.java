package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution52Test {

    @Test(dataProvider = "a")
    public void testTotalNQueens(int input, int expect) throws Exception {
        assertEquals(new Solution52().totalNQueens(input), expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{0, 0},
                new Object[]{1, 1},
                new Object[]{2, 0},
                new Object[]{3, 0},
                new Object[]{4, 2},
                new Object[]{5, 10},
                new Object[]{6, 4},
                new Object[]{7, 40},
                new Object[]{8, 92},
                new Object[]{9, 352},
                new Object[]{10, 724},
        };
    }
}