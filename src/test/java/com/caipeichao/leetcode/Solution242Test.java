package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution242Test {

    @Test(dataProvider = "a")
    public void testIsAnagram(String a, String b, boolean expect) throws Exception {
        boolean actual = new Solution242().isAnagram(a, b);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"abc", "cba", true},
                new Object[]{"", "", true},
                new Object[]{"a", "a", true},
                new Object[]{"car", "rat", false},
                new Object[]{"anagram", "nagaram", true},
        };
    }

}