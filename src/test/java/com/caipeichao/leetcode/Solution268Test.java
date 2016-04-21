package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution268Test {
    @Test(dataProvider = "a")
    public void test(String input, int expect) {
        int[] in = TestUtils.parseIntArray(input);
        int out = new Solution268().missingNumber(in);
        assertEquals(out, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1,0,2,3,4,6", 5},
                new Object[]{"0,1,3", 2},
        };
    }
}