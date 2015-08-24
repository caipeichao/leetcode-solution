package com.caipeichao.leetcode;

public class Solution110_2 {
    public boolean isBalanced(TreeNode root) {
        Height height = new Height();
        return isBalancedAndGetHeight(root, height);
    }

    public boolean isBalancedAndGetHeight(TreeNode root, Height height) {
        if (root == null) return true;

        // 计算左右节点的高度
        Height leftHeight = new Height();
        if (!isBalancedAndGetHeight(root.left, leftHeight)) {
            return false;
        }
        Height rightHeight = new Height();
        if (!isBalancedAndGetHeight(root.right, rightHeight)) {
            return false;
        }

        // 如果高度差超过1说明不平衡
        if (Math.abs(leftHeight.height - rightHeight.height) > 1) {
            return false;
        }
        height.height = Math.max(leftHeight.height, rightHeight.height) + 1;
        return true;
    }

    public static class Height {
        public int height;
    }
}
