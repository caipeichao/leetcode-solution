package com.caipeichao.leetcode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        // 计算链表总长度
        Return r = reverseList(head);
        if (r.last != head) return null;
        reverseList(head);
        int totalLength = r.count;
        if(totalLength == 1) return null;

        // 进入链表的一半
        int half = (totalLength) / 2;
        ListNode halfNode = head;
        for (int i = 0; i < half; i++) {
            halfNode = halfNode.next;
        }

        // 计算一圈的长度
        ListNode node = halfNode.next;
        int loopLength = 1;
        while (node != halfNode) {
            loopLength++;
            node = node.next;
        }

        // 计算从head到环的距离
        int toLoop = (totalLength - loopLength - 1) / 2;

        // 找出循环开始的节点
        node = head;
        for (int i = 0; i < toLoop; i++) {
            node = node.next;
        }
        return node;
    }

    private Return reverseList(ListNode head) {
        ListNode node = head;
        ListNode lastNode = null;
        int count = 0;
        while (node != null) {
            ListNode next = node.next;
            node.next = lastNode;
            lastNode = node;
            node = next;
            count++;
        }
        Return result = new Return();
        result.last = lastNode;
        result.count = count;
        return result;
    }

    private static class Return {
        public ListNode last;
        public int count;
    }
}

