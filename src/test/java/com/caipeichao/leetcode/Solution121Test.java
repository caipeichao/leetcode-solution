package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution121Test {
    @Test(dataProvider = "a")
    public void test(String input, int expect) {
        String[] split = input.split(",");
        int[] prices = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            String e = split[i];
            int x = Integer.parseInt(e);
            prices[i] = x;
        }
        int actual = new Solution121().maxProfit(prices);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"4,5,7,1,2,3", 3},
                new Object[]{"2,1,4", 3},
                new Object[]{"3,2,1", 0},
        };
    }
}