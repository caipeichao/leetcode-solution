package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution66Test {

    @Test(dataProvider = "a")
    public void testPlusOne(String input, String expect) throws Exception {
        int[] parse = parseDigits(input);
        int[] actual = new Solution66().plusOne(parse);
        String actualString = toString(actual);
        assertEquals(actualString, expect);
    }

    private int[] parseDigits(String a) {
        int[] result = new int[a.length()];
        int i = 0;
        for (char c : a.toCharArray()) {
            result[i] = Integer.parseInt(Character.toString(c));
            i++;
        }
        return result;
    }

    private String toString(int[] nums) {
        StringBuilder result = new StringBuilder();
        for (int e : nums) {
            result.append(e);
        }
        return result.toString();
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"0", "1"},
                new Object[]{"123", "124"},
                new Object[]{"199", "200"},
                new Object[]{"1999999999999999999999", "2000000000000000000000"},
                new Object[]{"999999999999999999999", "1000000000000000000000"},
        };
    }
}