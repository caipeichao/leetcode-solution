package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caipeichao on 15/8/16.
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        // 定义一个隐藏节点，简化问题
        ListNode resultNode = new ListNode(0);
        resultNode.next = head;

        // 扫描所有的节点，两两交换
        ListNode lastNode = resultNode;
        while (head != null) {
            ListNode node1 = next(lastNode);
            if (node1 == null) break;
            ListNode node2 = next(node1);
            if (node2 == null) break;
            ListNode node3 = next(node2);
            lastNode.next = node2;
            node2.next = node1;
            node1.next = node3;
            lastNode = node1;
        }

        // 通过隐藏节点返回结果
        return resultNode.next;
    }

    private ListNode next(ListNode node) {
        if (node == null) return null;
        return node.next;
    }
}
