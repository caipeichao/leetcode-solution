package com.caipeichao.leetcode;

import java.util.IdentityHashMap;
import java.util.Map;

public class Solution337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        Max max = rob2(root);
        int result = Math.max(max.inclusive, max.exclusive);
        return result;
    }

    public Max rob2(TreeNode node) {
        if (node == null) return new Max();

        // 计算左右各个节点的最大值情况
        Max left = rob2(node.left);
        Max right = rob2(node.right);

        // 分别计算包含本节点的最大值和不包含本节点的最大值
        Max result = new Max();
        result.exclusive = getExclusiveMax(node, left, right);
        result.inclusive = getInclusiveMax(node, left, right);
        result.inclusive = Math.max(result.exclusive, result.inclusive);
        return result;
    }

    private int getInclusiveMax(TreeNode node, Max left, Max right) {
        return node.val + left.exclusive + right.exclusive;
    }

    private int getExclusiveMax(TreeNode node, Max left, Max right) {
        return left.inclusive + right.inclusive;
    }

    private static class Max {
        public int inclusive;
        public int exclusive;
    }
}
