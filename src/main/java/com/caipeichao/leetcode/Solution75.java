package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/15.
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        // 计数
        int[] counts = new int[3];
        for (int e : nums) {
            counts[e]++;
        }

        // 返回结果
        int i = 0;
        for (int k = 0; k < counts.length; k++) {
            int count = counts[k];
            for (int j = 0; j < count; j++) {
                nums[i] = k;
                i++;
            }
        }
    }
}
