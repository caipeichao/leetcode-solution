package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.*;

public class Solution109Test {

    @Test(dataProvider = "a")
    public void testSortedListToBST(int length, String expect) throws Exception {
        // 生成链表
        ListNode linkedList = null;
        for (int i = length - 1; i >= 0; i--) {
            ListNode newNode = new ListNode(i);
            newNode.next = linkedList;
            linkedList = newNode;
        }

        // 生成bst
        TreeNode tree = new Solution109().sortedListToBST(linkedList);
        String actual = TestUtils.toString(tree);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{0, "{#"},
                new Object[]{1, "{0,#,#}"},
                new Object[]{2, "{0,#,1,#,#}"},
                new Object[]{3, "{1,0,2,#,#,#,#}"},
                new Object[]{4, "{1,0,2,#,#,#,3,#,#}"},
                new Object[]{5, "{2,0,3,#,1,#,4,#,#,#,#}"},
                new Object[]{6, "{2,0,4,#,1,3,5,#,#,#,#,#,#}"},
                new Object[]{7, "{3,1,5,0,2,4,6,#,#,#,#,#,#,#,#}"},
                new Object[]{8, "{3,1,5,0,2,4,6,#,#,#,#,#,#,#,7,#,#}"},
                new Object[]{9, "{4,1,6,0,2,5,7,#,#,#,3,#,#,#,8,#,#,#,#}"},
                new Object[]{10, "{4,1,7,0,2,5,8,#,#,#,3,#,6,#,9,#,#,#,#,#,#}"},
        };
    }
}