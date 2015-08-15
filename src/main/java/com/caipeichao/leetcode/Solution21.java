package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/15.
 */
public class Solution21 {
    private ListNode result = null;
    private ListNode last = null;

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        while (true) {
            if (l1 == null && l2 == null) break;
            if (l1 == null) {
                add(l2.val);
                l2 = l2.next;
                continue;
            }
            if (l2 == null) {
                add(l1.val);
                l1 = l1.next;
                continue;
            }
            if (l1.val < l2.val) {
                add(l1.val);
                l1 = l1.next;
                continue;
            } else {
                add(l2.val);
                l2 = l2.next;
                continue;
            }
        }
        return result;
    }

    private void add(int x) {
        if (result == null) {
            result = new ListNode(x);
            last = result;
        } else {
            ListNode newNode = new ListNode(x);
            last.next = newNode;
            last = newNode;
        }
    }
}
