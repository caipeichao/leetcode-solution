package com.caipeichao.leetcode;

public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        internal(root);
    }

    private TreeNode internal(TreeNode node) {
        if (node == null) return null;
        TreeNode nodeLeft = node.left;
        TreeNode nodeRight = node.right;
        TreeNode nodeEnd = node;
        if (nodeLeft != null) {
            node.left = null;
            node.right = nodeLeft;
            nodeEnd = internal(nodeLeft);
        }
        if (nodeRight != null) {
            nodeEnd.right = nodeRight;
            nodeEnd = internal(nodeRight);
        }
        return nodeEnd;
    }
}
