package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution9Test {

    @Test(dataProvider = "a")
    public void testIsPalindrome(int input, boolean expect) throws Exception {
        boolean actual = new Solution9().isPalindrome(input);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{1, true},
                new Object[]{0, true},
                new Object[]{12321, true},
                new Object[]{12322, false},
        };
    }
}
