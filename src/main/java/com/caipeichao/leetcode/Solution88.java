package com.caipeichao.leetcode;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 将输入的数据复制一份
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        int[] output = nums1;
        nums1 = nums1Copy;

        // 归并排序
        int p1 = 0;
        int p2 = 0;
        while (true) {
            if (p1 >= m && p2 >= n) {
                return;
            }
            if (p1 >= m) {
                output[p1 + p2] = nums2[p2];
                p2++;
                continue;
            }
            if (p2 >= n) {
                output[p1 + p2] = nums1[p1];
                p1++;
                continue;
            }
            if (nums1[p1] > nums2[p2]) {
                output[p1 + p2] = nums2[p2];
                p2++;
                continue;
            }
            output[p1 + p2] = nums1[p1];
            p1++;
        }
    }
}
