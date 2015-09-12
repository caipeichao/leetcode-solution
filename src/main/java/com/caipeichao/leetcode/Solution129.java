package com.caipeichao.leetcode;

public class Solution129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return sumNumbers(0, root);
    }

    private int sumNumbers(int prefix, TreeNode root) {
        int thisVal = prefix * 10 + root.val;
        if (root.left == null && root.right == null) {
            return thisVal;
        }
        int result = 0;
        if (root.left != null) {
            result += sumNumbers(thisVal, root.left);
        }
        if (root.right != null) {
            result += sumNumbers(thisVal, root.right);
        }
        return result;
    }
}
