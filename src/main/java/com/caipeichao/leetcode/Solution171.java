package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/6/22.
 */
public class Solution171 {
    public int titleToNumber(String s) {
        int result = 0;
        String alphaTable = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char c : s.toCharArray()) {
            result *= 26;
            result += alphaTable.indexOf(c);
            result++;
        }
        return result;
    }
}
