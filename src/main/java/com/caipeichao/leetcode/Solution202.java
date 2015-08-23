package com.caipeichao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caipeichao on 15/8/21.
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<Integer>();
        while (true) {
            int squareSum = squareSum(n);
            if (squareSum == 1) return true;
            if (visited.contains(squareSum)) {
                return false;
            }
            visited.add(squareSum);
            n = squareSum;
        }
    }

    private int squareSum(int n) {
        String digits = Integer.toString(n);
        int result = 0;
        for (int i = 0; i < digits.length(); i++) {
            int parse = Integer.parseInt(Character.toString(digits.charAt(i)));
            result += parse * parse;
        }
        return result;
    }
}
