package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/15.
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        return last;
    }
}
