package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution347Test {
    @Test(dataProvider = "a")
    public void test(String nums, int k, String exp) {
        int[] nums2 = TestUtils.parseIntArray(nums);
        List<Integer> actualList = new Solution347().topKFrequent(nums2, k);
        String actual = TestUtils.toString2(actualList);
        assertEquals(actual, exp);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1,1,1,2,2,3", 1, "1"},
                new Object[]{"1,1,1,2,2,3", 0, ""},
                new Object[]{"1,1,1,2,2,3", 2, "12"},
                new Object[]{"1,1,1,2,2,3,3,3,3", 2, "31"},
        };
    }
}