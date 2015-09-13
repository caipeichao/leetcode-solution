package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution225 {
    private LinkedList<Integer> queue = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        // 加入到原来队列的最前面
        LinkedList<Integer> queue2 = new LinkedList<Integer>();
        queue2.add(x);
        int n = queue.size();
        for (int i = 0; i < n; i++) {
            Integer item = queue.pop();
            queue2.add(item);
        }

        // 再次反转
        queue = queue2;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.pop();
    }

    // Get the top element.
    public int top() {
        return queue.peekFirst();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}

