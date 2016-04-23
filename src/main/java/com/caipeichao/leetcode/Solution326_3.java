package com.caipeichao.leetcode;

public class Solution326_3 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
