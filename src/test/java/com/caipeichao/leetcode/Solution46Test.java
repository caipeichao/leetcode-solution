package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution46Test {
    @Test(dataProvider = "a")
    public void test(String input, String output) {
        int[] inputArray = decodeArray(input);
        Solution46 a = new Solution46();
        List<List<Integer>> actual = a.permute(inputArray);
        String actualResult = encodeArray(actual);
        assertEquals(actualResult, output);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1,2,3", "1,2,3,;1,3,2,;2,1,3,;2,3,1,;3,1,2,;3,2,1,;"},
                new Object[]{"2,2,2", "2,2,2,;"},
                new Object[]{"1,2,2", "1,2,2,;2,1,2,;2,2,1,;"},
        };
    }

    private int[] decodeArray(String input) {
        String[] split = input.split(",");
        int[] result = new int[split.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = parseInt(split[i]);
        }
        return result;
    }

    private int parseInt(String s) {
        return Integer.parseInt(s);
    }

    private String encodeArray(List<List<Integer>> list) {
        StringBuilder result = new StringBuilder();
        for (List<Integer> e : list) {
            for (Integer i : e) {
                result.append(i);
                result.append(",");
            }
            result.append(";");
        }
        return result.toString();
    }
}