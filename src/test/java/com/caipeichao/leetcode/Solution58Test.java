package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution58Test {

    @Test(dataProvider = "a")
    public void testLengthOfLastWord(String text, int expect) throws Exception {
        int actual = new Solution58().lengthOfLastWord(text);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"hello world", 5},
                new Object[]{"hello", 5},
                new Object[]{"h", 1},
                new Object[]{"      h ", 1},
                new Object[]{"", 0},
                new Object[]{"fdajf sfda sf dsf adsf s    ", 1},
        };
    }
}