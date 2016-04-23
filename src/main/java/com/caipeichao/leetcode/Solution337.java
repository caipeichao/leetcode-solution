package com.caipeichao.leetcode;

import sun.tools.jconsole.MaximizableInternalFrame;

public class Solution337 {
    public int rob(TreeNode root) {
        Max max = rob2(root);
        return Math.max(max.inclusive, max.exclusive);
    }

    private Max rob2(TreeNode node) {
        // rob nothing
        if (node == null) return new Max();

        // recursive left node and right node
        Max left = rob2(node.left);
        Max right = rob2(node.right);

        // compute exclusive max and inclusive max
        Max result = new Max();

        // include self node, so exclude child node
        result.inclusive = node.val + left.exclusive + right.exclusive;

        // exclude self node, so include child node
        result.exclusive = left.inclusive + right.inclusive;

        // inclusive may less then exclusive
        result.inclusive = Math.max(result.exclusive, result.inclusive);
        return result;
    }

    private static class Max {
        public int inclusive;
        public int exclusive;
    }
}

