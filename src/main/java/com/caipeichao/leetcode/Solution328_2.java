package com.caipeichao.leetcode;

public class Solution328_2 {
    public ListNode oddEvenList(ListNode head) {
        // 特殊情况
        if (head == null) return null;
        if (head.next == null) return head;

        // 分别加到两个链表
        ListNode li1Head = head;
        ListNode li1Tail = head;
        ListNode li2Head = head.next;
        ListNode li2Tail = head.next;
        ListNode iter = head.next.next;
        while (true) {
            li1Tail.next = iter;
            li1Tail = iter;
            iter = iter.next;
            if (iter == null) break;
            li2Tail.next = iter;
            li2Tail = iter;
            iter = iter.next;
            if (iter == null) break;
        }

        // 合并两个链表
        li1Tail.next = li2Head;
        li2Tail.next = null;
        return li1Head;
    }
}
