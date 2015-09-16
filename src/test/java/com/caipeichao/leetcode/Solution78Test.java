package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution78Test {

    @Test(dataProvider = "a")
    public void testSubsets(String input, String expect) throws Exception {
        int[] a=TestUtils.parseIntArray(input);
        List<List<Integer>> actual = new Solution78().subsets(a);
        String actual2 = TestUtils.toString(actual);
        assertEquals(actual2, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1,2,3",",1,2,12,3,13,23,123,"},
                new Object[]{"4,1,0",",4,1,14,0,04,01,014,"},
                new Object[]{"1,3,5,7,8,9",",1,3,13,5,15,35,135,7,17,37,137,57,157,357,1357,8,18,38,138,58,158,358,1358,78,178,378,1378,578,1578,3578,13578,9,19,39,139,59,159,359,1359,79,179,379,1379,579,1579,3579,13579,89,189,389,1389,589,1589,3589,13589,789,1789,3789,13789,5789,15789,35789,135789,"},
        };
    }
}