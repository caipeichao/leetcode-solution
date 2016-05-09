package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution345Test {

    @Test(dataProvider = "a")
    public void testReverseVowels(String in, String ex) throws Exception {
        String ac = new Solution345().reverseVowels(in);
        assertEquals(ac, ex);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"", ""},
                new Object[]{"hello", "holle"},
                new Object[]{"nice", "neci"},
                new Object[]{"chuangqianmingyueguang", "chaungqeunmingyaigaung"},
                new Object[]{"leetcode", "leotcede"},
        };
    }
}