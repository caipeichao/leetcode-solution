package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution118Test {

    @Test
    public void test() {
        List<List<Integer>> actual = new Solution118().generate(5);
        String actual2 = TestUtils.toString(actual);
        assertEquals(actual2, "1,11,121,1331,14641,");
    }
}

