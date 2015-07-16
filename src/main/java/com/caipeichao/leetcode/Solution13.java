package com.caipeichao.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by caipeichao on 15/7/15.
 */
public class Solution13 {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int i;
        for (i = 1; i < chars.length; i++) {
            int v1 = getValue(chars[i - 1]);
            int v2 = getValue(chars[i]);
            if (v1 < v2) {
                result += v2 - v1;
                i++;
            } else {
                result += v1;
            }
        }
        if (i == chars.length) {
            result += getValue(chars[chars.length - 1]);
        }
        return result;
    }

    private int getValue(char c) {
        if (c == 'I') return 1;
        if (c == 'i') return 1;
        if (c == 'V') return 5;
        if (c == 'v') return 5;
        if (c == 'X') return 10;
        if (c == 'x') return 10;
        if (c == 'L') return 50;
        if (c == 'l') return 50;
        if (c == 'C') return 100;
        if (c == 'c') return 100;
        if (c == 'D') return 500;
        if (c == 'd') return 500;
        if (c == 'M') return 1000;
        if (c == 'm') return 1000;
        throw new RuntimeException("Bad char: " + c);
    }
}
