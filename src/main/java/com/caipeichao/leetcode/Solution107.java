package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // 安全检查
        if (root == null) return new ArrayList<List<Integer>>();

        // 从上到下的层序遍历
        List<List<TreeNode>> levels = new ArrayList<List<TreeNode>>();
        List<TreeNode> currentLevel = new ArrayList<TreeNode>();
        currentLevel.add(root);
        while (!currentLevel.isEmpty()) {
            levels.add(currentLevel);
            List<TreeNode> lastLevel = currentLevel;
            currentLevel = new ArrayList<TreeNode>();
            for (TreeNode node : lastLevel) {
                if (node.left != null) currentLevel.add(node.left);
                if (node.right != null) currentLevel.add(node.right);
            }
        }

        // 从下到上构建结果
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = levels.size() - 1; i >= 0; i--) {
            List<TreeNode> level = levels.get(i);
            List<Integer> levelValues = new ArrayList<Integer>();
            for (TreeNode node : level) {
                levelValues.add(node.val);
            }
            result.add(levelValues);
        }
        return result;
    }
}
