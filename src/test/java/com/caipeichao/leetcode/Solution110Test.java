package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution110Test {

    @Test
    public void testGetHeightRange() throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(4);
        
        Solution110.Height height = new Solution110().getHeightRange(root);
        assertEquals(height.toString(), "2,3");
    }
}