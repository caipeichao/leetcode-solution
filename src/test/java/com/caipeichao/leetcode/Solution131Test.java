package com.caipeichao.leetcode;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution131Test {
    @Test(dataProvider = "a")
    public void test(String input, String expect) {
        List<List<String>> actual = new Solution131().partition(input);
        String actualString = JSON.toJSONString(actual);
        assertEquals(actualString, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"", "[[]]"},
                new Object[]{"a", "[[\"a\"]]"},
                new Object[]{"aab", "[[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]]"},
                new Object[]{"abc", "[[\"a\",\"b\",\"c\"]]"},
                new Object[]{"ababcdedcbaba", "[[\"a\",\"b\",\"a\",\"b\",\"c\",\"d\",\"e\",\"d\",\"c\",\"b\",\"a\",\"b\",\"a\"],[\"a\",\"b\",\"a\",\"b\",\"c\",\"d\",\"e\",\"d\",\"c\",\"b\",\"aba\"],[\"a\",\"b\",\"a\",\"b\",\"c\",\"d\",\"e\",\"d\",\"c\",\"bab\",\"a\"],[\"a\",\"b\",\"a\",\"b\",\"c\",\"ded\",\"c\",\"b\",\"a\",\"b\",\"a\"],[\"a\",\"b\",\"a\",\"b\",\"c\",\"ded\",\"c\",\"b\",\"aba\"],[\"a\",\"b\",\"a\",\"b\",\"c\",\"ded\",\"c\",\"bab\",\"a\"],[\"a\",\"b\",\"a\",\"b\",\"cdedc\",\"b\",\"a\",\"b\",\"a\"],[\"a\",\"b\",\"a\",\"b\",\"cdedc\",\"b\",\"aba\"],[\"a\",\"b\",\"a\",\"b\",\"cdedc\",\"bab\",\"a\"],[\"a\",\"b\",\"a\",\"bcdedcb\",\"a\",\"b\",\"a\"],[\"a\",\"b\",\"a\",\"bcdedcb\",\"aba\"],[\"a\",\"b\",\"abcdedcba\",\"b\",\"a\"],[\"a\",\"bab\",\"c\",\"d\",\"e\",\"d\",\"c\",\"b\",\"a\",\"b\",\"a\"],[\"a\",\"bab\",\"c\",\"d\",\"e\",\"d\",\"c\",\"b\",\"aba\"],[\"a\",\"bab\",\"c\",\"d\",\"e\",\"d\",\"c\",\"bab\",\"a\"],[\"a\",\"bab\",\"c\",\"ded\",\"c\",\"b\",\"a\",\"b\",\"a\"],[\"a\",\"bab\",\"c\",\"ded\",\"c\",\"b\",\"aba\"],[\"a\",\"bab\",\"c\",\"ded\",\"c\",\"bab\",\"a\"],[\"a\",\"bab\",\"cdedc\",\"b\",\"a\",\"b\",\"a\"],[\"a\",\"bab\",\"cdedc\",\"b\",\"aba\"],[\"a\",\"bab\",\"cdedc\",\"bab\",\"a\"],[\"a\",\"babcdedcbab\",\"a\"],[\"aba\",\"b\",\"c\",\"d\",\"e\",\"d\",\"c\",\"b\",\"a\",\"b\",\"a\"],[\"aba\",\"b\",\"c\",\"d\",\"e\",\"d\",\"c\",\"b\",\"aba\"],[\"aba\",\"b\",\"c\",\"d\",\"e\",\"d\",\"c\",\"bab\",\"a\"],[\"aba\",\"b\",\"c\",\"ded\",\"c\",\"b\",\"a\",\"b\",\"a\"],[\"aba\",\"b\",\"c\",\"ded\",\"c\",\"b\",\"aba\"],[\"aba\",\"b\",\"c\",\"ded\",\"c\",\"bab\",\"a\"],[\"aba\",\"b\",\"cdedc\",\"b\",\"a\",\"b\",\"a\"],[\"aba\",\"b\",\"cdedc\",\"b\",\"aba\"],[\"aba\",\"b\",\"cdedc\",\"bab\",\"a\"],[\"aba\",\"bcdedcb\",\"a\",\"b\",\"a\"],[\"aba\",\"bcdedcb\",\"aba\"],[\"ababcdedcbaba\"]]"},
        };
    }
}