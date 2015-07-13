package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caipeichao on 15/7/13.
 */
public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);
        int minLength = Math.min(path1.size(), path2.size());
        if(minLength == 0) throw new RuntimeException("No path found");
        for (int i = 0; i < minLength; i++) {
            if (path1.get(i).val != path2.get(i).val) {
                if(i == 0) throw new RuntimeException("No common found");
                return path1.get(i - 1);
            }
        }
        return path1.get(minLength - 1);
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode node) {
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        while (true) {
            if (root.val == node.val) {
                result.add(root);
                return result;
            }
            if (node.val > root.val) {
                result.add(root);
                root = root.right;
                continue;
            }
            if (node.val < root.val) {
                result.add(root);
                root = root.left;
                continue;
            }
            throw new RuntimeException("BST should not contain same value");
        }
    }
}
