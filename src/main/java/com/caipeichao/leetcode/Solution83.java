package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/7/6.
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (true) {
            if (node == null) return head;
            if (node.next == null) return head;
            if (node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }
}
