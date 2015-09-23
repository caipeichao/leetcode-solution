package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution86Test {

    @Test(dataProvider = "a")
    public void testPartition(String input, int x, String expect) throws Exception {
        ListNode list = TestUtils.parseLinkedList(input);
        ListNode actual = new Solution86().partition(list, x);
        String actualString = TestUtils.toStringListNode(actual);
        assertEquals(actualString, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"[1]", 3, "[1]"},
                new Object[]{"[1]", 0, "[1]"},
                new Object[]{"[1,4,3,2,5,2]", 3, "[1,2,2,4,3,5]"},
                new Object[]{"[9,8,7,6,5,4]", 6, "[5,4,9,8,7,6]"},
        };
    }
}