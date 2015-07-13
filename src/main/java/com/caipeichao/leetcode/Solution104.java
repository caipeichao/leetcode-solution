package com.caipeichao.leetcode;

public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftResult = 0;
        if (root.left != null) {
            leftResult = maxDepth(root.left);
        }
        int rightResult = 0;
        if (root.right != null) {
            rightResult = maxDepth(root.right);
        }
        return Math.max(leftResult, rightResult) + 1;
    }
}
