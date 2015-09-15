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

    public static String toString(int[] b) {
        StringBuilder result = new StringBuilder();
        for (int e : b) {
            result.append(e);
        }
        return result.toString();
    }

    public static int[] parseIntArray(String input) {
        String[] a = input.split(",");
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = Integer.parseInt(a[i]);
        }
        return result;
    }
}
