package com.caipeichao.leetcode;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution171Test {
    private Solution171 solution;

    @BeforeTest
    public void init() {
        solution = new Solution171();
    }

    @Test(dataProvider = "a")
    public void testTitleToNumber(String input, int output) throws Exception {
        assertEquals(solution.titleToNumber(input), output);
    }

    @DataProvider(name = "a")
    public Object[][] provideA() {
        return new Object[][]{
                new Object[]{"A", 1},
                new Object[]{"B", 2},
                new Object[]{"C", 3},
                new Object[]{"Z", 26},
                new Object[]{"AA", 27},
                new Object[]{"AZ", 52},
                new Object[]{"BA", 53},
                new Object[]{"BZ", 78},
                new Object[]{"ZZ", 702},
                new Object[]{"AAA", 703},
        };
    }
}