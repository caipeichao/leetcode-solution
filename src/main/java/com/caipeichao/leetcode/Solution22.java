package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caipeichao on 15/8/15.
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<String>();
        if (n == 1) {
            List<String> result = new ArrayList<String>();
            result.add("()");
            return result;
        }
        List<String> result = new ArrayList<String>();
        for (int i = n - 1; i >= 0; i--) {
            int left = i;
            int right = n - 1 - i;
            result.addAll(generate(left, right));
        }
        return result;
    }

    public List<String> generate(int left, int right) {
        List<String> leftResult = generateParenthesis(left);
        if (leftResult.isEmpty()) leftResult.add("");
        List<String> rightResult = generateParenthesis(right);
        if (rightResult.isEmpty()) rightResult.add("");
        List<String> result = new ArrayList<String>();
        for (String leftE : leftResult) {
            for (String rightE : rightResult) {
                result.add("(" + leftE + ")" + rightE);
            }
        }
        return result;
    }
}
