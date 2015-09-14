package com.caipeichao.leetcode;

public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int result = Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        if (root.left != null) {
            result = Math.min(result, minDepth(root.left) + 1);
        }
        if (root.right != null) {
            result = Math.min(result, minDepth(root.right) + 1);
        }
        return result;
    }
}

