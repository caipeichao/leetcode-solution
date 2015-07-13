package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution137Test {
    @Test(dataProvider = "a")
    public void test(int[] in, int expect) {
        int actual = new Solution137().singleNumber(in);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{new int[]{1, 1, 1, 0}, 0},
                new Object[]{new int[]{1, 1, 1, 2}, 2},
                new Object[]{new int[]{1, 1, 1, 2, 2, 2, 111}, 111},
                new Object[]{new int[]{999999, 111, 222, 111, 222, 111, 222}, 999999},
        };
    }
}