package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by caipeichao on 15/7/5.
 */
public class Solution169_2 {
    public int majorityElement(int[] nums) {
        Random random = new Random();

        // 随机10个数，然后求10个数中出现次数最多的数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(nums.length);
            int num = nums[r];
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        // 求出现次数最多的数
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, new ValueComparator());
        return list.get(list.size() - 1).getKey();
    }

    private static class ValueComparator implements Comparator<Map.Entry<Integer, Integer>> {

        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            return Integer.compare(o1.getValue(), o2.getValue());
        }
    }
}
