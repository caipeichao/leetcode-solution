package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution289Test {
    @Test(dataProvider = "a")
    public void test(String board, String expect) {
        int[][] board2 = TestUtils.decodeIntArrayArray(board);
        new Solution289().gameOfLife(board2);
        String actual2 = TestUtils.encodeIntArrayArray(board2);
        assertEquals(actual2, expect);
    }

    @Test(dataProvider = "a")
    public void test2(String board, String expect) {
        int[][] board2 = TestUtils.decodeIntArrayArray(board);
        new Solution289_2().gameOfLife(board2);
        String actual2 = TestUtils.encodeIntArrayArray(board2);
        assertEquals(actual2, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1,0,0,0;0,0,1,0;0,1,0,0;0,1,0,0", "0,0,0,0;0,1,0,0;0,1,1,0;0,0,0,0"},
        };
    }

    @Test
    public void test2() {
        int[][] a = TestUtils.decodeIntArrayArray("1,2,3;2,3,4;3,4,5");
        assertEquals(a[0][1], 2);
        String b = TestUtils.encodeIntArrayArray(a);
        assertEquals(b, "1,2,3;2,3,4;3,4,5");
    }
}