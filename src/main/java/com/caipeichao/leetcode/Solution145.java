package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by caipeichao on 15/8/13.
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        Stack<Frame> frameStack = new Stack<Frame>();
        frameStack.push(new Frame(root, 0));
        while (!frameStack.isEmpty()) {
            Frame frame = frameStack.peek();
            if (frame.line == 0) {
                if (frame.root.left != null) {
                    frameStack.push(new Frame(frame.root.left, 0));
                }
                frame.line++;
            } else if (frame.line == 1) {
                if (frame.root.right != null) {
                    frameStack.push(new Frame(frame.root.right, 0));
                }
                frame.line++;
            } else if (frame.line == 2) {
                result.add(frame.root.val);
                frameStack.pop();
            }
        }
        return result;
    }

    private static class Frame {
        public TreeNode root;
        public int line;

        public Frame(TreeNode root, int line) {
            this.root = root;
            this.line = line;
        }
    }
}
