package com.caipeichao.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Solution677 {
public class MapSum {
    private TreeMap<String, Integer> map = new TreeMap<>();

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int result = 0;
        for (Map.Entry<String, Integer> entry : map.tailMap(prefix, true).entrySet()) {
            if (!entry.getKey().startsWith(prefix)) {
                break;
            }
            result += entry.getValue();
        }
        return result;
    }
}
}
