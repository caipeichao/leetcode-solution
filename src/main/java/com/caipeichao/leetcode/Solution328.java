package com.caipeichao.leetcode;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        LeetList odd = new LeetList();
        LeetList even = new LeetList();
        ListNode iter = head;
        int i = 0;
        while (iter != null) {
            if (i % 2 == 0) {
                odd.add(iter);
            } else {
                even.add(iter);
            }
            iter = iter.next;
            i++;
        }
        return merge(odd, even);
    }

    private ListNode merge(LeetList a, LeetList b) {
        if (a.tail != null) {
            a.tail.next = b.head;
        }
        if (b.tail != null) {
            b.tail.next = null;
        }
        return a.head;
    }

    static class LeetList {
        ListNode head;
        ListNode tail;

        void add(ListNode node) {
            if (head == null) head = node;
            if (tail != null) {
                tail.next = node;
            }
            tail = node;
        }
    }
}

