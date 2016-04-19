package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution258Test {

    @Test
    public void testAddDigits() throws Exception {
        int[] actual = new int[100];
        for (int i = 0; i < 100; i++) {
            actual[i] = new Solution258().addDigits(i);
        }
        String actualString = TestUtils.toString(actual);
        assertEquals(actualString, "01234567891023456789102345678910234567891023456789102345678910234567891023456789102345678910234567891023456789");
    }
}