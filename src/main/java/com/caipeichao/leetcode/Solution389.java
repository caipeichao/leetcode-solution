package com.caipeichao.leetcode;

public class Solution389 {
    public char findTheDifference(String s1, String s2) {
        // 计算两个字符串的最短长度
        int n1 = s1.length();
        int n2 = s2.length();
        int n = Math.min(n1, n2);

        // 尝试找出最短长度以内的不同
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) return c2;
        }

        // 超过最短长度了，拿第二个字符串
        assert s2.length() > n;
        return s2.charAt(n);
    }
}
