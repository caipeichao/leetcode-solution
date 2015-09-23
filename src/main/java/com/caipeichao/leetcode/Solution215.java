package com.caipeichao.leetcode;

import com.alibaba.fastjson.JSON;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return -1;
        int start = 0;
        int end = nums.length;
        k = nums.length - k;
        while (true) {
            int mid = checkedPartition(nums, start, end);
            if (mid == k) {
                return nums[mid];
            } else if (mid < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
    }

    public int checkedPartition(int[] nums, int start, int end) {
        int mid = partition(nums, start, end);
        swap(nums, start, mid);
        return mid;
    }

    public int partition(int[] nums, int start, int end) {
        int midNum = nums[start];
        int p1 = start;
        int p2 = end;
        while (true) {
            // 从前往后，找出比midNum小的数字
            while (true) {
                p1++;
                if (p1 >= end) return end - 1;
                if (nums[p1] > midNum) break;
            }

            // 从后往前，找出比midNum大
            while (true) {
                p2--;
                if (p2 < start) return start;
                if (nums[p2] < midNum) break;
            }

            // 循环终止条件
            if (p1 >= p2) {
                return p2;
            }

            // 交换上面找到的这两个元素
            swap(nums, p1, p2);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
