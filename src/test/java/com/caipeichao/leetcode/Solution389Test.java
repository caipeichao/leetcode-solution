package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution389Test {

    @Test(dataProvider = "a")
    public void testFindTheDifference(String a, String b, char expected) throws Exception {
        char actual = new Solution389().findTheDifference(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"a", "ba", 'b'},
                new Object[]{"a", "aa", 'a'},
                new Object[]{"a", "aa", 'a'},
        };
    }
}