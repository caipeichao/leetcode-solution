package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution4Test {
    @Test(dataProvider = "provide")
    public void test(String s1, String s2, int n, int expect) {
        Solution4.Solution s =new Solution4().new Solution();
        int[] nums1 = TestUtils.parseIntArray(s1);
        int[] nums2 = TestUtils.parseIntArray(s2);
        int actual = s.findKthDoubleArray(nums1, nums2, n);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "provide")
    public Object[][] provide() {
        return new Object[][]{
//                {"2", "1", 0, 1},
//                {"2", "1", 1, 2},
//                {"1", "2", 0, 1},
//                {"1", "2", 1, 2},
//                {"1,3,5", "2", 0, 1},
//                {"1,3,5", "2", 1, 2},
//                {"1,3,5", "2", 2, 3},
//                {"1,3,5", "2", 3, 5},
//                {"1,3,5", "2,4,6", 0, 1},
//                {"1,3,5", "2,4,6", 1, 2},
                {"1,3,5", "2,4,6", 2, 3},
                {"1,3,5", "2,4,6", 3, 4},
                {"1,3,5", "2,4,6", 4, 5},
                {"1,3,5", "2,4,6", 5, 6},
                {"1,3,5,7,9", "2,4,6", 6, 7},
                {"1,3,5,7,9", "2,4,6", 7, 9},
        };
    }
}