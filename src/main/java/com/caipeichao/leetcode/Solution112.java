package com.caipeichao.leetcode;

public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 树是空的
        if (root == null) {
            return false;
        }

        // 如果已经是根节点，看看求和是否符合指定的条件
        if (root.left == null && root.right == null) {
            if (root.val == sum) return true;
        }

        // 左边节点求和
        if (root.left != null) {
            if (hasPathSum(root.left, sum - root.val)) {
                return true;
            }
        }

        // 右边节点求和
        if (root.right != null) {
            if (hasPathSum(root.right, sum - root.val)) {
                return true;
            }
        }

        return false;
    }
}
