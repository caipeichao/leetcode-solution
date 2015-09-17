package com.caipeichao.leetcode;

import com.alibaba.fastjson.JSON;
import com.sun.deploy.util.StringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class Solution240Test {

    @Test(dataProvider = "B")
    public void testSearchMatrix(String input, int target, boolean expect) throws Exception {
        String[] lines = input.split(";");
        int[][] m = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            m[i] = TestUtils.parseIntArray(lines[i]);
        }

        boolean actual = new Solution240().searchMatrix(m, target);
        assertEquals(actual, expect);
    }

    @DataProvider(name = "B")
    public Object[][] provide2() {
        String a = "1,4,7,11,15;2,5,8,12,19;3,6,9,16,22;10,13,14,17,24;18,21,23,26,30";
        return new Object[][]{
                new Object[]{a, 3, true},
                new Object[]{a, 1, true},
                new Object[]{a, 2, true},
                new Object[]{a, 4, true},
                new Object[]{a, 5, true},
                new Object[]{a, 6, true},
                new Object[]{a, 7, true},
                new Object[]{a, 8, true},
                new Object[]{a, 10, true},
                new Object[]{a, 20, false},
                new Object[]{a, 22, true},
                new Object[]{a, 23, true},
                new Object[]{a, 19, true},
                new Object[]{a, 30, true},
                new Object[]{a, 18, true},
                new Object[]{a, 19, true},
        };
    }

    @Test(dataProvider = "a")
    public void testDrawLine(int width, int height, String expect) throws Exception {
        List<Solution240.Point> line = new Solution240().drawLine(width, height);
        String actual = toString(line);
        assertEquals(actual, expect);
    }

    private String toString(List<Solution240.Point> line) {
        List<String> result = new ArrayList<String>();
        for (Solution240.Point e : line) {
            result.add(toString(e));
        }
        return StringUtils.join(result, "");
    }

    private String toString(Solution240.Point p) {
        return String.format("(%s,%s)", p.x, p.y);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{10, 10, "(0,0)(1,1)(2,2)(3,3)(4,4)(5,5)(6,6)(7,7)(8,8)(9,9)"},
                new Object[]{5, 10, "(0,0)(0,1)(1,2)(1,3)(2,4)(2,5)(3,6)(3,7)(4,8)(4,9)"},
                new Object[]{3, 10, "(0,0)(0,1)(0,2)(0,3)(1,4)(1,5)(1,6)(2,7)(2,8)(2,9)"},
                new Object[]{1, 10, "(0,0)(0,1)(0,2)(0,3)(0,4)(0,5)(0,6)(0,7)(0,8)(0,9)"},
                new Object[]{10, 1, "(0,0)(1,0)(2,0)(3,0)(4,0)(5,0)(6,0)(7,0)(8,0)(9,0)"},
                new Object[]{10, 5, "(0,0)(1,0)(2,1)(3,1)(4,2)(5,2)(6,3)(7,3)(8,4)(9,4)"},
                new Object[]{5, 7, "(0,0)(0,1)(1,2)(2,3)(3,4)(3,5)(4,6)"}
        };
    }
}