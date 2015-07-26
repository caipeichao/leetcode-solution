package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution89Test {

    @Test(dataProvider = "a")
    public void testGrayCode(int n, String expect) throws Exception {
        List<Integer> actual = new Solution89().grayCode(n);
        StringBuilder result = new StringBuilder();
        for (int e : actual) {
            result.append(String.format("%" + n + "s", Integer.toBinaryString(e)).replace(" ", "0"));
            result.append(",");
        }
        assertEquals(result.toString(), expect);
    }

    @DataProvider(name = "a")
    public Object[][] provideTest() {
        return new Object[][]{
                new Object[]{1, "0,1,"},
                new Object[]{2, "00,01,11,10,"},
                new Object[]{3,"000,001,011,010,110,111,101,100,"},
        };
    }
}