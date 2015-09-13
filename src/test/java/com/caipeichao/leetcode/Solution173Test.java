package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class Solution173Test {
    @Test

    public void test() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        Solution173.BSTIterator i = new Solution173.BSTIterator(node);
        List<Integer> result = new ArrayList<Integer>();
        while (i.hasNext()) {
            result.add(i.next());
        }
        assertEquals(TestUtils.toString2(result), "4213");
    }
}