package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caipeichao on 15/7/26.
 */
public class Solution89 {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>(power2(n));
        result.add(0);
        for (int i = 0; i < n; i++) {
            genGrayCode(result);
        }
        return result;
    }

    private void genGrayCode(ArrayList<Integer> result) {
        int n = result.size();
        for (int i = n - 1; i >= 0; i--) {
            int newCode = result.get(i) ^ n;
            result.add(newCode);
        }
    }

    private int power2(int n) {
        if (n == 0) return 1;
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 2;
        }
        return result;
    }
}
