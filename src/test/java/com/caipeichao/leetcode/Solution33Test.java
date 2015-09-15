package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution33Test {

    @Test(dataProvider = "b")
    public void testSearch(String input, int target, int expect) throws Exception {
        int actual = new Solution33().search(TestUtils.parseIntArray(input), target);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "b")
    public Object[][] provideB(){
        return new Object[][]{
                new Object[]{"5,6,7,8,9,0,1,2", 6, 1},
                new Object[]{"5,6,7,8,9,0,1,2", 0, 5},
                new Object[]{"5,6,7,8,9,0,1,2", 1, 6},
                new Object[]{"5,6,7,8,9,0,1,2", 2, 7},
                new Object[]{"5,6,7,8,9,0,1,2", 3, -1},
                new Object[]{"5,6,7,8,9,0,1,2", 4, -1},
                new Object[]{"5,6,7,8,9,0,1,2", 5, 0},

                new Object[]{"5,6,7,8,9,0,1,2", 7, 2},
                new Object[]{"5,6,7,8,9,0,1,2", 8, 3},
                new Object[]{"5,6,7,8,9,0,1,2", 9, 4},
        };
    }

    @Test(dataProvider = "a")
    public void testFindSplit(String input, int expect) throws Exception {
        int actual = new Solution33().findSplit(TestUtils.parseIntArray(input));
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"5,6,7,8,9,0,1,2", 5},
                new Object[]{"1,2,3,4", -1},
                new Object[]{"2,3,1", 2},
                new Object[]{"2,3,1", 2},
                new Object[]{"2,3,4,1", 3},
                new Object[]{"5,6,7,8,9,0,1,2,3,4", 5},
                new Object[]{"5,6,7,8,9,0,1,2,3", 5},
                new Object[]{"5,6,7,8,9,0,1", 5},
                new Object[]{"5,6,7,8,9,0", 5},
        };
    }
}