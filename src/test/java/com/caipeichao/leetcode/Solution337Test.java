package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution337Test {

    @Test(dataProvider = "a")
    public void testRob(String input, int expect) throws Exception {
        TreeNode node = TestUtils.parseTreeNode(input);
        int actual = new Solution337().rob(node);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"[null]", 0},
                new Object[]{"[3,2,3,null,3,null,1]", 7},
                new Object[]{"[3,4,5,1,3,null,1]", 9},
        };
    }
}