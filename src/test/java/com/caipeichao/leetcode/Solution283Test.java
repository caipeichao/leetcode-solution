package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution283Test {

    @Test(dataProvider = "a")
    public void testMoveZeroes(String input, String expect) throws Exception {
        int[] intArray = TestUtils.parseIntArray(input);
        new Solution283().moveZeroes(intArray);
        String actualString = TestUtils.toString(intArray);
        assertEquals(actualString, expect);
    }

    @Test(dataProvider = "a")
    public void testMoveZeroes2(String input, String expect) throws Exception {
        int[] intArray = TestUtils.parseIntArray(input);
        new Solution283_2().moveZeroes(intArray);
        String actualString = TestUtils.toString(intArray);
        assertEquals(actualString, expect);
    }

    @DataProvider(name = "a")
    private Object[][] provide() {
        return new Object[][]{
                new Object[]{"0", "0"},
                new Object[]{"0,0", "00"},
                new Object[]{"0,0,0", "000"},
                new Object[]{"0,0,1,0,1,0,1,0,0", "111000000"},
                new Object[]{"0,0,0,0,0,1,0,0,0,0,0,0,1,0,0", "110000000000000"},
                new Object[]{"0,0,0,0,0,2,0,0,1,3,0,0,1,0,0", "213100000000000"},
        };
    }
}