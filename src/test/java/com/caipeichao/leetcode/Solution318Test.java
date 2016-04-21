package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution318Test {

    @Test(dataProvider = "a")
    public void testMaxProduct(String in, int expect) throws Exception {
        String[] a = in.split(",");
        int x = new Solution318().maxProduct(a);
        assertEquals(x, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"abcw,baz,foo,bar,xtfn,abcdef", 16},
                new Object[]{"a,aa,aaa,aaaa", 0},
                new Object[]{"a,ab,abc,d,cd,bcd,abcd", 4},
        };
    }
}