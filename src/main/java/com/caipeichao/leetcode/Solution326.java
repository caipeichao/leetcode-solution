package com.caipeichao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution326 {
    public boolean isPowerOfThree(int n) {
        if (n < 0) return false;
        if (n == 0) return false;
        if (n == 1) return true;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n = n / 3;
        }
        return true;
    }
}

