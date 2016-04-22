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

    @Test(dataProvider = "a")
    public void testFindDuplicate2(String in, int expect) throws Exception {
        int[] in2 = TestUtils.parseIntArray(in);
        int ac = new Solution287_2().findDuplicate(in2);
        assertEquals(ac, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"6,3,4,7,2,2,1,5", 2},
                new Object[]{"4,5,6,4,1,7,3,2", 4},
                new Object[]{"1,2,3,4,5,6,4", 4},
                new Object[]{"37,34,3,17,64,62,20,97,94,90,9,58,38,24,50,76,49,72,21,45,30,16,53,65,66,39,32,59,69,14,61,70,13,15,27,88,71,31,67,78,2,42,28,82,80,18,12,11,89,54,86,5,10,73,75,79,6,91,60,98,1,83,23,33,85,40,56,41,84,20,96,22,46,55,29,19,57,8,81,7,35,26,68,52,43,95,48,36,92,25,4,99,44,87,77,93,47,63,74,51", 20},
        };
    }
}