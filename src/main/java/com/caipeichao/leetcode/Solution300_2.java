package com.caipeichao.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Solution300_2 {
    public int lengthOfLIS(int[] nums) {
        // n
        int n = nums.length;

        // 遍历每个元素，找出前面比它小的元素，加上长度
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            // 找出比当前元素小的，记录最长序列
            Integer smaller = map.lowerKey(nums[i]);
            int len = 1;
            while (smaller != null) {
                Integer len2 = map.get(smaller);
                len = Math.max(len, len2 + 1);
                smaller = map.lowerKey(smaller);
            }
            map.put(nums[i], len);
        }

        // 找出最长序列长度
        int max = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet())
            max = Math.max(max, e.getValue());
        return max;
    }
}
