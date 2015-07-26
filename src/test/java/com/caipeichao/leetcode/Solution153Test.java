package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution153Test {
    @Test(dataProvider = "a")
    public void test(String input, int expect) {
        String[] split = input.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        int actual = new Solution153().findMin(nums);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provideTest() {
        return new Object[][]{
                new Object[]{"1,2,3", 1},
                new Object[]{"1", 1},
                new Object[]{"7,8,9,0,1,2,3,4,5,6", 0},
        };
    }
}