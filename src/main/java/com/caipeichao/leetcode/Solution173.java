package com.caipeichao.leetcode;

import java.util.Stack;

public class Solution173 {
    public static class BSTIterator {
        private Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            if (root != null) {
                stack.push(root);
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            if (stack.isEmpty()) {
                return false;
            }
            return true;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            while (true) {
                TreeNode node = stack.peek();
                if (node.left == null) {
                    stack.pop();
                    if (node.right != null) {
                        stack.push(node.right);
                        node.right = null;
                    }
                    return node.val;
                } else {
                    stack.push(node.left);
                    node.left = null;
                }
            }
        }
    }
}

