package com.caipeichao.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by caipeichao on 15/8/18.
 */
public class Solution117 {

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> level = new LinkedList<TreeLinkNode>();
        level.add(root);
        Queue<TreeLinkNode> nextLevel = new LinkedList<TreeLinkNode>();
        while (true) {
            TreeLinkNode lastNode = null;
            while (!level.isEmpty()) {
                TreeLinkNode node = level.poll();
                if (node == null) continue;
                if (lastNode != null) {
                    lastNode.next = node;
                }
                lastNode = node;

                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            if (nextLevel.isEmpty()) break;
            level = nextLevel;
            nextLevel = new LinkedList<TreeLinkNode>();
        }
    }

}
