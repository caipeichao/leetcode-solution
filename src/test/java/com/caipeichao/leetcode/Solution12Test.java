package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution12Test {
    @Test(dataProvider = "a")
    public void test(int input, String expect) {
        String actual = new Solution12().intToRoman(input);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{1, "I"},
                new Object[]{2, "II"},
                new Object[]{3, "III"},
                new Object[]{4, "IV"},
                new Object[]{5, "V"},
                new Object[]{6, "VI"},
                new Object[]{7, "VII"},
                new Object[]{8, "VIII"},
                new Object[]{9, "IX"},
                new Object[]{10, "X"},
                new Object[]{11, "XI"},
                new Object[]{12, "XII"},
                new Object[]{99, "XCIX"},
                new Object[]{123, "CXXIII"},
                new Object[]{3999, "MMMCMXCIX"},
                new Object[]{1234, "MCCXXXIV"},
                new Object[]{1024, "MXXIV"},
                new Object[]{2999, "MMCMXCIX"},
        };
    }
}