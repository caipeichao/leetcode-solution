package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution78 {
    private int[] sortMap;

    public List<List<Integer>> subsets(int[] nums) {
        // 构建排序映射
        buildSortMap(nums);

        boolean[] bits = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (true) {
            result.add(asList(nums, bits));
            if (!increase(bits)) {
                break;
            }
        }
        return result;
    }

    private boolean increase(boolean[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (!bits[i]) {
                bits[i] = true;
                for (int j = 0; j < i; j++) {
                    bits[j] = false;
                }
                return true;
            }
        }
        return false;
    }

    private List<Integer> asList(int[] nums, boolean[] bits) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < bits.length; i++) {
            int j = sortMap[i];
            if (bits[j]) {
                result.add(nums[j]);
            }
        }
        return result;
    }

    private void buildSortMap(int[] nums) {
        List<Item> list = new ArrayList<Item>();
        for (int i = 0; i < nums.length; i++) {
            Item item = new Item();
            item.num = nums[i];
            item.index = i;
            list.add(item);
        }
        Collections.sort(list, new ItemCompare());

        sortMap = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            sortMap[i] = list.get(i).index;
        }
    }

    private static class Item {
        public int num;
        public int index;
    }

    private static class ItemCompare implements Comparator<Item> {

        @Override
        public int compare(Item o1, Item o2) {
            return Integer.compare(o1.num, o2.num);
        }
    }
}

