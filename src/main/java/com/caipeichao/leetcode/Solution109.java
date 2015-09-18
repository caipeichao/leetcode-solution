package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        // 取出所有数据
        List<Integer> list = new ArrayList<Integer>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        // 二分法构建BST
        int length = list.size();
        return bst(list, 0, length);
    }

    private TreeNode bst(List<Integer> list, int start, int end) {
        // 找出中间值
        int length = end - start;
        if (length == 0) return null;
        if (length == 1) {
            return new TreeNode(list.get(start));
        }
        int mid = start + (length - 1) / 2;
        int midNum = list.get(mid);

        // 左中右三个部分
        TreeNode root = new TreeNode(midNum);
        root.left = bst(list, start, mid);
        root.right = bst(list, mid + 1, end);
        return root;
    }
}

