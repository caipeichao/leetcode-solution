package com.caipeichao.leetcode;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution136Test {

    private Solution136 a;

    @BeforeTest
    public void init() {
        a = new Solution136();
    }

    @Test
    public void testBasic() {
        int result = a.singleNumber(new int[] { 1, 1, 2 });
        assertEquals(result, 2);
    }
}
