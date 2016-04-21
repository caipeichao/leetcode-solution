package com.caipeichao.leetcode;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] stat1 = stat(s);
        int[] stat2 = stat(t);
        return isArrayEquals(stat1, stat2);
    }

    private int[] stat(String s) {
        int[] result = new int[26];
        for (char c : s.toCharArray()) {
            result[c - 'a']++;
        }
        return result;
    }

    private boolean isArrayEquals(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}

