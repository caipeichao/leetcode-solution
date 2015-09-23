package com.caipeichao.leetcode;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        // 遍历链表，将元素进行分类
        ListNode node = head;
        LinkList list1 = new LinkList();
        LinkList list2 = new LinkList();
        while (node != null) {
            ListNode nodeNext = node.next;
            node.next = null;
            if (node.val < x) list1.append(node);
            else list2.append(node);
            node = nodeNext;
        }

        // 将两条链表合成一条
        list1.append(list2);
        return list1.head();
    }

    private static class LinkList {
        private ListNode head;
        private ListNode tail;

        public void append(ListNode node) {
            if (isEmpty()) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        public void append(LinkList list) {
            if (isEmpty()) {
                head = list.head;
                tail = list.tail;
            } else {
                tail.next = list.head;
                tail = list.tail;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public ListNode head() {
            return head;
        }
    }
}

