package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution216Test {

    @Test(dataProvider = "a")
    public void testCombinationSum3(int k, int n, String expect) throws Exception {
        List<List<Integer>> a = new Solution216().combinationSum3(k, n);
        String actual = TestUtils.toString(a);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{3, 6, "123,"},
                new Object[]{3, 7, "124,"},
                new Object[]{3, 8, "125,134,"},
                new Object[]{3, 9, "126,135,234,"},
        };
    }
}