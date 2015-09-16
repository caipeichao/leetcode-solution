package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        List<List<TreeNode>> levels = new ArrayList<List<TreeNode>>();
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        levels.add(level);
        while (true) {
            List<TreeNode> newLevel = new ArrayList<TreeNode>();
            for (TreeNode node : level) {
                if (node.left != null) newLevel.add(node.left);
                if (node.right != null) newLevel.add(node.right);
            }
            if (newLevel.isEmpty()) break;
            levels.add(newLevel);
        }

        // 取出每个节点的值
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (List<TreeNode> e : levels) {
            List<Integer> subResult = new ArrayList<Integer>();
            for (TreeNode e2 : e) {
                subResult.add(e2.val);
            }
            result.add(subResult);
        }
        return result;
    }
}
