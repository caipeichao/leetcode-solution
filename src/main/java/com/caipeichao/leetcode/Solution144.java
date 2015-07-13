package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caipeichao on 15/6/22.
 */
public class Solution144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        visit(root, result);
        return result;
    }

    private void visit(TreeNode root, List<Integer> out) {
        out.add(root.val);
        if (root.left != null) {
            visit(root.left, out);
        }
        if (root.right != null) {
            visit(root.right, out);
        }
    }
}
