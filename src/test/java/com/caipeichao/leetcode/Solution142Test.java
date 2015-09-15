package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution142Test {

    @Test(dataProvider = "a")
    public void testDetectCycle(int from, int to, int expect) throws Exception {
        ListNode[] nodes = new ListNode[10];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ListNode(i);
        }
        for (int i = 1; i < nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        nodes[from].next = nodes[to];
        ListNode actual = new Solution142().detectCycle(nodes[0]);
        assertEquals(actual.val, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{9, 0, 0},
                new Object[]{9, 1, 1},
                new Object[]{9, 2, 2},
                new Object[]{9, 3, 3},
                new Object[]{9, 4, 4},
                new Object[]{9, 5, 5},
                new Object[]{9, 6, 6},
                new Object[]{9, 7, 7},
                new Object[]{9, 8, 8},
                new Object[]{9, 9, 9},
        };
    }

    @Test
    public void test() {
        ListNode r = new Solution142().detectCycle(new ListNode(1));
        assertNull(r);
    }

    @Test
    public void test2() {
        ListNode no = new ListNode(1);
        no.next = no;
        ListNode r = new Solution142().detectCycle(no);
        assertSame(r, no);
    }
}