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
        assertEquals(actualString, "0123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789");
    }

    @Test
    public void testAddDigits2() throws Exception {
        int[] actual = new int[100];
        for (int i = 0; i < 100; i++) {
            actual[i] = new Solution258_2().addDigits(i);
        }
        String actualString = TestUtils.toString(actual);
        assertEquals(actualString, "0123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789123456789");
    }
}