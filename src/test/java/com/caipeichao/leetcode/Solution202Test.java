package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution202Test {
    @Test(dataProvider = "a")
    public void test(int input, boolean expect) {
        Solution202 a = new Solution202();
        boolean actual = a.isHappy(input);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{1, true},
                new Object[]{19, true},
                new Object[]{20, false},
        };
    }
}