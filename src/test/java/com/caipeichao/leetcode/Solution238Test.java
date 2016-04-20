package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution238Test {

    @Test(dataProvider = "a")
    public void testProductExceptSelf(String input, String expect) throws Exception {
        int[] in = TestUtils.parseIntArray(input);
        int[] out = new Solution238().productExceptSelf(in);
        String actual = TestUtils.toString2(out);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1","0:1"},
                new Object[]{"1,2,3,4","0:24,1:12,2:8,3:6"},
        };
    }
}