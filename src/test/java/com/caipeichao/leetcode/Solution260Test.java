package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution260Test {
    @Test(dataProvider = "a")
    public void test(String input, String expect) {
        int[] nums = TestUtils.parseIntArray(input);
        int[] result = new Solution260().singleNumber(nums);
        Arrays.sort(result);
        String actualString = TestUtils.toString(result);
        assertEquals(actualString, expect);
    }

    @Test(dataProvider = "a")
    public void test2(String input, String expect) {
        int[] nums = TestUtils.parseIntArray(input);
        int[] result = new Solution260_2().singleNumber(nums);
        Arrays.sort(result);
        String actualString = TestUtils.toString(result);
        assertEquals(actualString, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1,1,2,2,3,4", "34"},
                new Object[]{"1,3,1,2,2,4", "34"},
        };
    }
}