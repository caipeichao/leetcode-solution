package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by caipeichao on 15/6/22.
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>(1000);
        while (head != null) {
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}
