package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution215Test {

    @Test(dataProvider = "a")
    public void testFindKthLargest(String input, int k, int expect) throws Exception {
        int[] nums = TestUtils.parseJsonArray(input);
        int actual = new Solution215().findKthLargest(nums, k);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        String a = "[5,1,2,9,8,7,1,1,2,2,5,4,7,5,4]";
        return new Object[][]{
                new Object[]{a, 1, 9},
                new Object[]{a, 2, 8},
                new Object[]{a, 3, 7},
                new Object[]{a, 4, 7},
                new Object[]{a, 5, 5},
                new Object[]{a, 6, 5},
                new Object[]{a, 7, 5},
                new Object[]{a, 8, 4},
                new Object[]{a, 9, 4},
                new Object[]{a, 10, 2},
                new Object[]{a, 11, 2},
                new Object[]{a, 12, 2},
                new Object[]{a, 13, 1},
                new Object[]{a, 14, 1},
                new Object[]{a, 15, 1},
        };
    }

    @Test(dataProvider = "b")
    public void testPartition(String input, int start, int end, int expect) {
        int[] inputArray = TestUtils.parseJsonArray(input);
        int actual = new Solution215().partition(inputArray, start, end);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "b")
    public Object[][] providePartition() {
        return new Object[][]{
                new Object[]{"[2,1,3]", 0, 3, 1},
                new Object[]{"[2,3,1]", 0, 3, 1},
                new Object[]{"[1,2,3]", 0, 3, 0},
                new Object[]{"[1,3,2]", 0, 3, 0},
                new Object[]{"[3,1,2]", 0, 3, 2},
                new Object[]{"[3,2,1]", 0, 3, 2},
                new Object[]{"[3,2,1]", 0, 3, 2},
                new Object[]{"[5,1,2,9,8,7,1,1,2,2,5,4,7,5,4]", 0, 1, 0},
                new Object[]{"[5,1,2,9,8,7,1,1,2,2,5,4,7,5,4]", 0, 2, 1},
                new Object[]{"[5,1,2,9,8,7,1,1,2,2,5,4,7,5,4]", 0, 3, 2},
                new Object[]{"[5,1,2,9,8,7,1,1,2,2,5,4,7,5,4]", 0, 4, 2},
                new Object[]{"[5,1,2,9,8,7,1,1,2,2,5,4,7,5,4]", 0, 5, 2},
                new Object[]{"[5,1,2,9,8,7,1,1,2,2,5,4,7,5,4]", 0, 6, 2},
                new Object[]{"[5,1,2,9,8,7,1,1,2,2,5,4,7,5,4]", 0, 7, 3},
        };
    }
}
