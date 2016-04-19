package com.caipeichao.leetcode;

public class Solution258 {
    public int addDigits(int num) {
        while (num > 9) {
            num = sumDigits(num);
        }
        return num;
    }

    private int sumDigits(int x) {
        int result = 0;
        while (x != 0) {
            result += x % 10;
            x = x / 10;
        }
        return result;
    }
}

