package com.caipeichao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution389 {
    public char findTheDifference(String s1, String s2) {
        // 按字符统计数量
        Map<Character, Integer> m1 = stats(s1);
        Map<Character, Integer> m2 = stats(s2);

        // 根据统计结果找出变多的字母
        return diff(m1, m2);
    }

    private Map<Character, Integer> stats(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : s.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }

    private char diff(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for (char c : m1.keySet()) {
            if (m1.get(c).equals(m2.get(c))) {
                m2.remove(c);
            }
        }
        if (m2.size() != 1) {
            throw new RuntimeException("Expect add only one type char");
        }
        char result = m2.keySet().iterator().next();
        if (m2.get(result) - m1.getOrDefault(result, 0) != 1) {
            throw new RuntimeException("Expect add only one char");
        }
        return result;
    }
}
