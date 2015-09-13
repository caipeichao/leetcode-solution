package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> lastRow = null;
        for (int i = 0; i < numRows; i++) {
            if (lastRow == null) {
                lastRow = new ArrayList<Integer>();
                lastRow.add(1);
                result.add(lastRow);
            } else {
                List<Integer> newRow = new ArrayList<Integer>();
                for (int j = 0; j <= lastRow.size(); j++) {
                    int item = arrayGet(lastRow, j) + arrayGet(lastRow, j - 1);
                    newRow.add(item);
                }
                result.add(newRow);
                lastRow = newRow;
            }
        }
        return result;
    }

    private int arrayGet(List<Integer> list, int n) {
        if (n < 0) return 0;
        if (n >= list.size()) return 0;
        return list.get(n);
    }
}

