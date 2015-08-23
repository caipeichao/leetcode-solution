package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/23.
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (!isBalanced2(root.left)) {
            return false;
        }
        if (!isBalanced2(root.right)) {
            return false;
        }
        return true;
    }

    public boolean isBalanced2(TreeNode root) {
        Height height = getHeightRange(root);
        if (height.getDiff() > 1) {
            return false;
        } else {
            return true;
        }
    }

    public Height getHeightRange(TreeNode node) {
        if (node == null) {
            return new Height();
        }
        Height leftHeight = getHeightRange(node.left);
        Height rightHeight = getHeightRange(node.right);
        Height mergeHeight = Height.merge(leftHeight, rightHeight);
        mergeHeight.increment();
        return mergeHeight;
    }

    public static class Height {
        public int minHeight;
        public int maxHeight;

        public static Height merge(Height a, Height b) {
            Height result = new Height();
            result.minHeight = Math.min(a.minHeight, b.minHeight);
            result.maxHeight = Math.max(a.maxHeight, b.maxHeight);
            return result;
        }

        public void increment() {
            minHeight++;
            maxHeight++;
        }

        public int getDiff() {
            return maxHeight - minHeight;
        }

        @Override
        public String toString() {
            return minHeight + "," + maxHeight;
        }
    }
}
