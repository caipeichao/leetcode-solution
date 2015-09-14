package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution190Test {

    @Test(dataProvider = "a")
    public void testReverseBits(String input, String expect) throws Exception {
        int input2 = Integer.parseInt(input, 2);
        long actual = new Solution190().reverseBits(input2);
        if (actual < 0) actual += 0x100000000L;
        String actual2 = Long.toString(actual, 2);
        assertEquals(actual2, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"0", "0"},
                new Object[]{"1", "10000000000000000000000000000000"},
                new Object[]{"10", "1000000000000000000000000000000"},
                new Object[]{"11", "11000000000000000000000000000000"},
                new Object[]{"1001", "10010000000000000000000000000000"},
                new Object[]{"11111111110000000000111111111", "11111111100000000001111111111000"},
        };
    }
}