package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution328Test {

    @Test(dataProvider = "a")
    public void testOddEvenList(String in, String expect) throws Exception {
        ListNode a = TestUtils.parseLinkedList(in);
        ListNode r = new Solution328().oddEvenList(a);
        String ac = TestUtils.toStringListNode(r);
        assertEquals(ac, expect);
    }

    @Test(dataProvider = "a")
    public void testOddEvenList2(String in, String expect) throws Exception {
        ListNode a = TestUtils.parseLinkedList(in);
        ListNode r = new Solution328_2().oddEvenList(a);
        String ac = TestUtils.toStringListNode(r);
        assertEquals(ac, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"[]", "[]"},
                new Object[]{"[1,2,3,4,5]", "[1,3,5,2,4]"},
        };
    }
}