package com.caipeichao.leetcode;

public class Solution242_2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        long xSum = 0;
        long ySum = 0;
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i);
            int y = t.charAt(i);
            xSum += Double.doubleToLongBits(Math.sin(x));
            ySum += Double.doubleToLongBits(Math.sin(y));
        }
        return xSum == ySum;
    }
}

