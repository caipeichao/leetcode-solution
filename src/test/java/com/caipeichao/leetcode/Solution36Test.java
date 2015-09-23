package com.caipeichao.leetcode;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution36Test {

    @Test(dataProvider = "checker")
    public void testChecker(String input, String expect) {
        Solution36.Checker checker = new Solution36.Checker();
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            boolean r = checker.add(c);
            result.append(r ? "1" : "0");
        }
        assertEquals(result.toString(), expect);
    }

    @DataProvider(name = "checker")
    public Object[][] provideChecker() {
        return new Object[][]{
                new Object[]{".........", "111111111"},
                new Object[]{"1........", "111111111"},
                new Object[]{"123456789", "111111111"},
                new Object[]{"112233445", "101010101"},
        };
    }

    @Test(dataProvider = "a")
    public void test(String input, boolean expect) {
        char[][] board = parseBoard(input);
        boolean actual = new Solution36().isValidSudoku(board);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"[\"........2\",\"......6..\",\"..14..8..\",\".........\",\".........\",\"....3....\",\"5.86.....\",\".9....4..\",\"....5....\"]", true},
        };
    }

    private char[][] parseBoard(String input) {
        List<String> list = (List) JSON.parseArray(input);
        char[][] result = new char[9][];
        int i = 0;
        for (String e : list) {
            result[i] = e.toCharArray();
            i++;
        }
        return result;
    }
}