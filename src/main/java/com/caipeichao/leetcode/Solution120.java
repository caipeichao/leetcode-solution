package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> last = new ArrayList<Integer>();
        for (List<Integer> row : triangle) {
            List<Integer> minPath = new ArrayList<Integer>();
            for (int i = 0; i < row.size(); i++) {
                int min2;
                int e = row.get(i);
                int rowLength = row.size();
                if (last.isEmpty()) min2 = e;
                else if (i == 0) min2 = last.get(0) + e;
                else if (i == rowLength - 1) min2 = last.get(i - 1) + e;
                else min2 = Math.min(last.get(i - 1) + e, last.get(i) + e);
                minPath.add(min2);
            }
            last = minPath;
        }
        return min(last);
    }

    private int min(List<Integer> li) {
        int result = Integer.MAX_VALUE;
        for (int e : li) {
            result = Math.min(result, e);
        }
        return result;
    }
}
