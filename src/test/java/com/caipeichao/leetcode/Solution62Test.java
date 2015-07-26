package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution62Test {
    @Test(dataProvider = "a")
    public void test(int m, int n, int expect) {
        int actual=new Solution62().uniquePaths(m,n);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provideTest(){
        return new Object[][]{
                new Object[]{2,1,1},
                new Object[]{2,2,2},
                new Object[]{3,2,3},
                new Object[]{3,3,6},
        };
    }
}