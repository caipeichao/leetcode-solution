package com.caipeichao.leetcode;

public class Solution287_2 {
    public int findDuplicate(int[] nums) {
        // find ring
        int slow = nums.length; // 必须要从末尾开始走，不然可能第一个点就出现死循环
        int fast = nums.length;
        while (true) {
            slow = nums[slow - 1];
            fast = nums[fast - 1];
            fast = nums[fast - 1];
            if (slow == fast) break;
        }

        // find duplicate
        int find = nums.length;
        while (true) {
            slow = nums[slow - 1];
            find = nums[find - 1];
            if (slow == find) {
                return slow;
            }
        }
    }
}
