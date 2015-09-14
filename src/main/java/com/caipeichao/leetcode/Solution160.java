package com.caipeichao.leetcode;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 同步起点
        int lenA = len(headA);
        int lenB = len(headB);
        if (lenA > lenB) {
            headA = move(headA, lenA - lenB);
        } else {
            headB = move(headB, lenB - lenA);
        }

        // 两条链表同时向前，寻找公共节点
        while (true) {
            if (headA == null) return null;
            if (headB == null) return null;
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
    }

    private int len(ListNode node) {
        int result = 0;
        while (node != null) {
            result++;
            node = node.next;
        }
        return result;
    }

    private ListNode move(ListNode node, int count) {
        for (int i = 0; i < count; i++) {
            node = node.next;
        }
        return node;
    }
}

