package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) return new ArrayList<Integer>();
        rowIndex++;
        int[] lastRow = new int[rowIndex];
        lastRow[0] = 1;
        int[] result = new int[rowIndex];
        for (int i = 1; i < rowIndex; i++) {
            int rowLength = i + 1;
            int lastRowLength = i;
            for (int j = 0; j < rowLength; j++) {
                result[j] = get(lastRow, lastRowLength, j - 1) + get(lastRow, lastRowLength, j);
            }
            int[] temp = lastRow;
            lastRow = result;
            result = temp;
        }
        return asList(lastRow);
    }

    private int get(int[] a, int length, int n) {
        if (n < 0) return 0;
        if (n >= length) return 0;
        return a[n];
    }

    private List<Integer> asList(int[] li) {
        List<Integer> result = new ArrayList<Integer>();
        for (int e : li) {
            result.add(e);
        }
        return result;
    }
}
