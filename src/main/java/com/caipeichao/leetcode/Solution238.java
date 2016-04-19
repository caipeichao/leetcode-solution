package com.caipeichao.leetcode;

public class Solution238 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
