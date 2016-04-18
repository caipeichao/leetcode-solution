package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution338Test {

    @Test(dataProvider = "test")
    public void testCountBits(int input, String expect) throws Exception {
        int[] actual = new Solution338().countBits(input);
        String actualString = TestUtils.toString(actual);
        assertEquals(actualString, expect);
    }

    @DataProvider(name = "test")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{0, "0"},
                new Object[]{1, "01"},
                new Object[]{2, "011"},
                new Object[]{4, "01121"},
                new Object[]{5, "011212"},
                new Object[]{100, "01121223122323341223233423343445122323342334344523343445344545561223233423343445233434453445455623343"},
        };
    }
}