package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution241 {
    public List<Integer> diffWaysToCompute(String input) {
        // 如果当前输入的只有一个数字，那就返回这个数字
        if (!containsOperator(input)) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(Integer.parseInt(input));
            return result;
        }

        // 寻找运算符
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isOperator(c)) {
                // 计算左边的排列
                String leftPart = input.substring(0, i);
                List<Integer> leftResult = diffWaysToCompute(leftPart);

                // 计算右边的排列
                String rightPart = input.substring(i + 1);
                List<Integer> rightResult = diffWaysToCompute(rightPart);

                // 将两边的结果进行组合
                char operator = c;
                List<Integer> subResult = explode(leftResult, operator, rightResult);
                result.addAll(subResult);
            }
        }
        return result;
    }

    private boolean containsOperator(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isOperator(c)) {
                return true;
            }
        }
        return false;
    }

    private List<Integer> explode(List<Integer> left, char operator, List<Integer> right) {
        List<Integer> result = new ArrayList<Integer>();
        for (int e : left) {
            for (int e2 : right) {
                int subResult = calculate(e, operator, e2);
                result.add(subResult);
            }
        }
        return result;
    }

    private int calculate(int left, char operator, int right) {
        switch (operator) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            default:
                throw new RuntimeException("Unsupport operator: " + operator);
        }
    }

    public boolean isOperator(char c) {
        if (c == '+') return true;
        if (c == '-') return true;
        if (c == '*') return true;
        return false;
    }
}

