package com.caipeichao.leetcode;

public class Solution58 {
    public int lengthOfLastWord(String s) {
        int fromIndex = skipTailSpaces(s);
        if (fromIndex == -1) return 0;
        int lastSpace = s.lastIndexOf(' ', fromIndex);
        return fromIndex - lastSpace;
    }

    public int skipTailSpaces(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                return i;
            }
        }
        return -1;
    }
}
