package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution287Test {

    @Test(dataProvider = "a")
    public void testFindDuplicate(String in, int expect) throws Exception {
        int[] in2 = TestUtils.parseIntArray(in);
        int ac = new Solution287().findDuplicate(in2);
        assertEquals(ac, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1,2,3,4,5,6,4", 4},
        };
    }
}