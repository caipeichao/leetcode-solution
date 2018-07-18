package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

public class Solution559 {
    public int maxDepth(Node root) {
        int[] result = new int[1];
        maxDepthAsync(root, (x) -> {
            result[0] = x;
        });
        mainLoop();
        return result[0];
    }

    private Stack<Runnable> stack = new Stack<>();

    private void maxDepthAsync(Node root, Consumer<Integer> callback) {
        submit(() -> {
            maxDepth(root, callback);
        });
    }

    private void maxDepth(Node root, Consumer<Integer> callback) {
        if (root == null) {
            callback.accept(0);
            return;
        }
        List<Node> children = root.children;
        if (children == null) children = new ArrayList<>();
        int expectedCallback = children.size();
        if (expectedCallback == 0) {
            callback.accept(1);
            return;
        }
        int[] actualCallback = new int[1];
        int[] maxDepth = new int[1];
        for (Node node : children) {
            maxDepthAsync(node, (x) -> {
                maxDepth[0] = Math.max(maxDepth[0], x);
                actualCallback[0]++;
                if (actualCallback[0] != expectedCallback) return;
                callback.accept(maxDepth[0] + 1);
            });
        }
    }

    private void submit(Runnable x) {
        stack.push(x);
    }

    private void mainLoop() {
        while (!stack.empty()) {
            Runnable task = stack.pop();
            task.run();
        }
    }
}