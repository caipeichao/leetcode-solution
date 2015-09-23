package com.caipeichao.leetcode;

public class Solution236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Return r = dfs(root, p, q);
        return r.node;
    }

    public Return dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 空的节点，不知道如何处理
        if (root == null) return new Return();

        // 左边如果找到公共节点就直接返回
        Return leftReturn = new Return();
        if (root.left != null) {
            leftReturn = dfs(root.left, p, q);
        }
        if (leftReturn.found()) {
            return leftReturn;
        }

        // 右边如果找到公共节点就直接返回
        Return rightReturn = new Return();
        if (root.right != null) {
            rightReturn = dfs(root.right, p, q);
        }
        if (rightReturn.found()) {
            return rightReturn;
        }

        // 将左右两边的结果进行合并，如果此时两边分别找到了一个，那就说明当前节点就是最近共同祖先了
        Return currentReturn = current(root, p, q);
        Return mergeReturn = merge(leftReturn, rightReturn);
        mergeReturn = merge(mergeReturn, currentReturn);
        if (mergeReturn.leftFound && mergeReturn.rightFound) {
            mergeReturn.node = root;
        }

        // 返回结果
        return mergeReturn;
    }

    public Return current(TreeNode root, TreeNode p, TreeNode q) {
        Return result = new Return();
        if (root == p) {
            result.leftFound = true;
        }
        if (root == q) {
            result.rightFound = true;
        }
        return result;
    }

    public Return merge(Return r1, Return r2) {
        Return result = new Return();
        if (r1.node != null) result.node = r1.node;
        if (r2.node != null) result.node = r2.node;
        result.leftFound = r1.leftFound || r2.leftFound;
        result.rightFound = r1.rightFound || r2.rightFound;
        return result;
    }

    public static class Return {
        public TreeNode node;
        public boolean leftFound;
        public boolean rightFound;

        public boolean found() {
            return node != null;
        }
    }
}
