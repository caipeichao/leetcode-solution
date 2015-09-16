package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i <= nums.length; i++) {
            result.addAll(combination(nums, i));
        }
        return result;
    }

    public List<List<Integer>> combination(int[] nums, int k) {
        if(k == 0) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }

        // 初始化循环变量
        int n = nums.length;
        int[] i = new int[k];
        for (int j = 0; j < k; j++) {
            i[j] = j;
        }

        // 每次增加一个，直到无法增加
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (true) {
            result.add(asList(nums, i));
            if (!increase(i, n)) {
                break;
            }
        }
        return result;
    }

    private List<Integer> asList(int[] nums, int[] i) {
        List<Integer> result = new ArrayList<Integer>();
        for (int e : i) {
            result.add(nums[e]);
        }
        return result;
    }

    public boolean increase(int[] i, int n) {
        int k = i.length;
        for (int j = k - 1; k >= 0; k--) {
            i[j]++;
            int max = n - (k - 1 - j);
            if (i[j] < max) {
                // 符合条件，准备退出
                for (int m = j + 1; m < k; m++) {
                    i[m] = i[m - 1] + 1;
                }
                return true;
            }
        }
        return false;
    }
}
