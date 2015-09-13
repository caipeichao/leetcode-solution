package com.caipeichao.leetcode;

import java.util.List;

public class TestUtils {
    public static String toString(List<List<Integer>> list) {
        StringBuilder result = new StringBuilder();
        for (List<Integer> e : list) {
            for (Integer e2 : e) {
                result.append(e2);
            }
            result.append(",");
        }
        return result.toString();
    }

    public static String toString2(List<Integer> list) {
        StringBuilder result = new StringBuilder();
        for (Integer e : list) {
            result.append(e);
        }
        return result.toString();
    }
}
