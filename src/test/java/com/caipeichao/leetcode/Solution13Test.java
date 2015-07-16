package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution13Test {

    @Test(dataProvider = "t")
    public void testRomanToInt(String input, int expect) throws Exception {
        int actual = new Solution13().romanToInt(input);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "t")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"I", 1},
                new Object[]{"IV", 4},
                new Object[]{"VI", 6},
                new Object[]{"MXII", 1012},
                new Object[]{"IX", 9},
                new Object[]{"XII", 12},
        };
    }
}