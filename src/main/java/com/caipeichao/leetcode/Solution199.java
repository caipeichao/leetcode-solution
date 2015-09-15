package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        // 层序遍历
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        result.add(root.val);
        while (true) {
            List<TreeNode> newLevel = new ArrayList<TreeNode>();
            for (TreeNode e : level) {
                if (e.left != null) newLevel.add(e.left);
                if (e.right != null) newLevel.add(e.right);
            }
            if (newLevel.isEmpty()) break;
            result.add(newLevel.get(newLevel.size() - 1).val);
            level = newLevel;
        }
        return result;
    }
}
