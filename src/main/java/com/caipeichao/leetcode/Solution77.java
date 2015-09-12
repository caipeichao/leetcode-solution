package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        // 初始化循环变量
        int[] j = new int[k];
        for (int i = 0; i < k; i++) {
            j[i] = i;
        }

        // 每次对j增加1
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (true) {
            List<Integer> subResult = new ArrayList<Integer>();
            for (int e : j) {
                subResult.add(e);
            }
            result.add(subResult);
            if (!increase(j, n)) return result;
        }
    }

    private boolean increase(int[] j, int n) {

        for (int i = j.length - 1; i >= 0; i--) {
            j[i]++;

            // 如果没有进位了，就可以准备退出了
            if (j[i] < n - (j.length - i - 1)) {
                // major位的进位之后要把minor位设置为最小值
                for (int k = i + 1; k < j.length; k++) {
                    j[k] = j[k - 1] + 1;
                }
                return true;
            }
        }

        // 无法进位了
        return false;
    }
}
