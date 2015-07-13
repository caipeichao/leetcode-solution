package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution235Test {

    @Test
    public void testLowestCommonAncestor() throws Exception {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);

        Solution235 a = new Solution235();
        a.lowestCommonAncestor(root, root, root.right);
    }
}