package com.caipeichao.leetcode;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val < min) return false;
        if (root.val > max) return false;
        if (!isValidBST(root.left, min, root.val - 1L)) return false;
        if (!isValidBST(root.right, root.val + 1L, max)) return false;
        return true;
    }
}
