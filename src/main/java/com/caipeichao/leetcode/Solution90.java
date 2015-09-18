package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(new ArrayList<Integer>());
            return result;
        }

        // 唯一化并统计数量
        Arrays.sort(nums);
        Return r = uniqueAndCount(nums);

        // 生成结果
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] pointers = new int[r.nums.length];
        while (true) {
            result.add(asList(r.nums, pointers));
            if (!increase(pointers, r.count)) {
                break;
            }
        }
        return result;
    }

    private boolean increase(int[] pointers, int[] count) {
        for (int i = 0; i < pointers.length; i++) {
            pointers[i]++;
            if (pointers[i] <= count[i]) {
                // 符合条件了，准备退出
                for (int j = 0; j < i; j++) {
                    pointers[j] = 0;
                }
                return true;
            }
        }
        return false;
    }

    private List<Integer> asList(int[] nums, int[] pointers) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < pointers[i]; j++) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    private Return uniqueAndCount(int[] nums) {
        ArrayList<Integer> resultNums = new ArrayList<Integer>();
        ArrayList<Integer> resultCount = new ArrayList<Integer>();
        for (int e : nums) {
            if (resultNums.isEmpty() || last(resultNums) != e) {
                resultNums.add(e);
                resultCount.add(1);
            } else {
                int count = last(resultCount);
                removeLast(resultCount);
                resultCount.add(count + 1);
            }
        }

        // 组装结果
        Return r = new Return();
        r.nums = toArray(resultNums);
        r.count = toArray(resultCount);
        return r;
    }

    private void removeLast(List<Integer> resultCount) {
        resultCount.remove(resultCount.size() - 1);
    }

    private int last(List<Integer> list) {
        return list.get(list.size() - 1);
    }

    private int[] toArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static class Return {
        public int[] nums;
        public int[] count;
    }
}
