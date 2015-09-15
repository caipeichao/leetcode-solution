package com.caipeichao.leetcode;

public class Solution9 {
    public boolean isPalindrome(int x) {
        String origin = Integer.toString(x);
        String reverse = reverse(origin);
        return origin.equals(reverse);
    }

    private String reverse(String x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();
        return sb.toString();
    }
}
