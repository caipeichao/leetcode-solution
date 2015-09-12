package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution77Test {
    @Test
    public void test() {
        List<List<Integer>> result = new Solution77().combine(6, 3);
        String actual = toString(result);
        assertEquals(actual, "");
    }

    private String toString(List<List<Integer>> list) {
        StringBuilder result = new StringBuilder();
        for (List<Integer> e : list) {
            for (Integer e2 : e) {
                result.append(e2);
            }
            result.append(",");
        }
        return result.toString();
    }
}