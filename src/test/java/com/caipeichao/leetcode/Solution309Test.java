package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution309Test {
    @Test(dataProvider = "a")
    public void test(String a, int b) {
        int[] c = TestUtils.parseIntArray(a);
        int d = new Solution309().maxProfit(c);
        assertEquals(d, b);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1", 0},
                new Object[]{"1,2", 1},
                new Object[]{"2,1", 0},
                new Object[]{"0,3,6,9,8,17", 17},
                new Object[]{"7,6,5,4,3,2,1,0", 0},
                new Object[]{"1,2,3,4,5,4,3,2,1,0,1,2,3,4,5", 9},
                new Object[]{"1,2,3,4,5", 4},
                new Object[]{"1,2,3,0,2", 3},
        };
    }
}