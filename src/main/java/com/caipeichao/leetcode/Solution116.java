package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * Created by caipeichao on 15/6/22.
 */
public class Solution116 {
    private static Set<Integer> nullNodes = buildNullNodes();

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        List<TreeLinkNode> levelOrder = levelOrderTraversal(root);
        for (int i = 0; i < levelOrder.size(); i++) {
            if (nullNodes.contains(i)) continue;
            levelOrder.get(i).next = levelOrder.get(i + 1);
        }
    }

    private static Set<Integer> buildNullNodes() {
        Set<Integer> result = new HashSet<Integer>();
        int n = 2;
        for (int i = 0; i < 32; i++) {
            result.add(n - 2);
            n *= 2;
        }
        return result;
    }

    public List<TreeLinkNode> levelOrderTraversal(TreeLinkNode root) {
        List<TreeLinkNode> result = new ArrayList<TreeLinkNode>();
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            result.add(node);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
    }
}
