package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution344Test {
    @Test
    public void test() {
        String x = new Solution344().reverseString("asdf");
        assertEquals(x, "fdsa");
    }
}