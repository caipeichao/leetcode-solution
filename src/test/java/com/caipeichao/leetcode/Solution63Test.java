package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution63Test {

    @Test(dataProvider = "a")
    public void testUniquePathsWithObstacles(String input, int expect) throws Exception {
        int[][] grid = TestUtils.parseIntGrid(input);
        int actual = new Solution63().uniquePathsWithObstacles(grid);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"[[0]]", 1},
                new Object[]{"[[1]]", 0},
                new Object[]{"[[0,0,0],[0,1,0],[0,0,0]]", 2},
                new Object[]{"[[0,0,0],[0,1,0],[0,0,0],[0,0,0],[0,0,0]]", 7},
        };
    }
}
