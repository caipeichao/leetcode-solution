package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // 初始化滑动变量
        int[] i = new int[k];
        for (int j = 0; j < k; j++) {
            i[j] = j + 1;
        }

        // 一直增加直到无法增加
        while (true) {
            if (sum(i) == n) {
                result.add(asList(i));
            }

            if (!increase(i, 9)) {
                return result;
            }
        }
    }

    private int sum(int[] a) {
        int result = 0;
        for (int e : a) {
            result += e;
        }
        return result;
    }

    private List<Integer> asList(int[] li) {
        List<Integer> result = new ArrayList<Integer>();
        for (int e : li) {
            result.add(e);
        }
        return result;
    }

    private boolean increase(int[] i, int max) {
        int n = i.length;
        for (int b = n - 1; b >= 0; b--) {
            i[b]++;

            // 找到符合条件的了，退出
            if (i[b] <= max - (n - 1 - b)) {
                for (int j = b + 1; j < n; j++) {
                    i[j] = i[j - 1] + 1;
                }
                return true;
            }
        }

        // 找不到符合条件的
        return false;
    }
}
