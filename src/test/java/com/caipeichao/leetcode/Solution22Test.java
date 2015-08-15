package com.caipeichao.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Solution22Test {

    @Test(dataProvider = "a")
    public void testGenerateParenthesis(int n, String expect) throws Exception {
        Solution22 a = new Solution22();
        List<String> actual = a.generateParenthesis(n);
        String actual2 = Arrays.toString(actual.toArray());
        assertEquals(actual2, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provideTest() {
        return new Object[][]{
                new Object[]{0, "[]"},
                new Object[]{1, "[()]"},
                new Object[]{2, "[(()), ()()]"},
                new Object[]{3, "[((())), (()()), (())(), ()(()), ()()()]"},
                new Object[]{4, "[(((()))), ((()())), ((())()), (()(())), (()()()), ((()))(), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]"},
        };
    }
}