package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution300Test {
    @Test(dataProvider = "a")
    public void test(String a, int expect) {
        int[] a2 = TestUtils.decodeIntArray(a);
        int a3 = new Solution300().lengthOfLIS(a2);
        assertEquals(a3, expect);
    }

    @Test(dataProvider = "a")
    public void test2(String a, int expect) {
        int[] a2 = TestUtils.decodeIntArray(a);
        int a3 = new Solution300_2().lengthOfLIS(a2);
        assertEquals(a3, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"10,9,2,5,3,7,101,18", 4},
        };
    }
}