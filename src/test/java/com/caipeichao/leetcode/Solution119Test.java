package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution119Test {

    @Test(dataProvider = "a")
    public void testGetRow(int n, String expect) throws Exception {
        String actual = TestUtils.toString2(new Solution119().getRow(n));
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{0, "1"},
                new Object[]{1, "11"},
                new Object[]{2, "121"},
                new Object[]{3, "1331"},
                new Object[]{4, "14641"},

        };
    }
}