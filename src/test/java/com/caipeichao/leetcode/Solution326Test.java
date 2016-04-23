package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution326Test {

    @Test(dataProvider = "a")
    public void testIsPowerOfThree(int a, boolean ex) throws Exception {
        boolean ac = new Solution326().isPowerOfThree(a);
        assertEquals(ac, ex);
    }

    @Test(dataProvider = "a")
    public void testIsPowerOfThree2(int a, boolean ex) throws Exception {
        boolean ac = new Solution326_2().isPowerOfThree(a);
        assertEquals(ac, ex);
    }

    @Test(dataProvider = "a")
    public void testIsPowerOfThree3(int a, boolean ex) throws Exception {
        boolean ac = new Solution326_3().isPowerOfThree(a);
        assertEquals(ac, ex);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{-3, false},
                new Object[]{1, true},
                new Object[]{0, false},
                new Object[]{3, true},
                new Object[]{2, false},
                new Object[]{4, false},
                new Object[]{5, false},
                new Object[]{9, true},
        };
    }
}