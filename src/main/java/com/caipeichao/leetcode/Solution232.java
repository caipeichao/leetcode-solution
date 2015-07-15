package com.caipeichao.leetcode;

import java.util.Stack;

/**
 * Created by caipeichao on 15/7/14.
 */
public class Solution232 {
    private Stack<Integer> stack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        reverseStack();
        stack.pop();
        reverseStack();
    }

    // Get the front element.
    public int peek() {
        reverseStack();
        int result = stack.peek();
        reverseStack();
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }

    private void reverseStack() {
        Stack<Integer> result = new Stack<Integer>();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            result.push(stack.pop());
        }
        stack = result;
    }
}
