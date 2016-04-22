package com.caipeichao.leetcode;

public class Solution287_2 {
    public int findDuplicate(int[] nums) {
        // find ring
        int slow = nums.length;
        int fast = nums.length;
        System.out.println("slow: " + slow);
        System.out.println("       fast: " + fast);
        while (true) {
            slow = nums[slow - 1];
            System.out.println("slow: " + slow);
            fast = nums[fast - 1];
            System.out.println("       fast: " + fast);
            fast = nums[fast - 1];
            System.out.println("       fast: " + fast);
            if (slow == fast) break;
        }

        // find duplicate
        int find = nums.length;
        while (true) {
            slow = nums[slow - 1];
            System.out.println("slow: " + slow);
            find = nums[find - 1];
            System.out.println("              find: " + find);
            if (slow == find) {
                return slow;
            }
        }
    }
}
