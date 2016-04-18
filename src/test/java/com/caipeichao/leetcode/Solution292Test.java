package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution292Test {

    @Test
    public void testCanWinNim() throws Exception {
        boolean[] actual = new boolean[100];
        for (int i = 0; i < 100; i++) {
            actual[i] = new Solution292().canWinNim(i);
        }
        String actualString = TestUtils.toString(actual);
        assertEquals(actualString, "FTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTT");
    }

    @Test
    public void testCanWinNim2() throws Exception {
        boolean[] actual = new boolean[100];
        for (int i = 0; i < 100; i++) {
            actual[i] = new Solution292_2().canWinNim(i);
        }
        String actualString = TestUtils.toString(actual);
        assertEquals(actualString, "FTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTTFTTT");
    }
}