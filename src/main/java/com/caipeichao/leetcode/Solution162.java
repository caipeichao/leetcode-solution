package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/24.
 */
public class Solution162 {
    public int findPeakElement(int[] nums) {
        // 长度很小，不需要二分查找
        if (nums.length == 1) return 0;
        if (nums.length == 2) return nums[0] < nums[1] ? 1 : 0;

        // 看看两侧的变化趋势，左边必须递增，右边必须递减
        if (nums[0] > nums[1]) return 0;
        int n = nums.length;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        // 通过二分查找定位最高点
        return binarySearch(nums, 0, n);
    }

    private int binarySearch(int[] nums, int start, int end) {
        while (true) {
            if (end - start <= 1) return start;
            int mid = (end + start - 1) / 2;
            int midValue1 = nums[mid];
            int midValue2 = nums[mid + 1];
            if (midValue1 < midValue2) {
                start = mid + 1;
            } else {
                end = mid + 1;
            }
        }
    }
}
