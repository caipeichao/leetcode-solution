package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by caipeichao on 15/6/22.
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>(256);
        Stack<Object> stack = new Stack<Object>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object o = stack.pop();
            if (o instanceof Integer) {
                result.add((Integer) o);
                continue;
            }
            TreeNode node = (TreeNode) o;
            if (node.right != null) stack.push(node.right);
            stack.push(node.val);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }
}
