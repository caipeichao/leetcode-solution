package com.caipeichao.leetcode;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Solution241Test {

    @Test(dataProvider = "a")
    public void testDiffWaysToCompute(String input, String expect) throws Exception {
        List<Integer> actual = new Solution241().diffWaysToCompute(input);
        String actualString = JSON.toJSONString(actual);
        assertEquals(actualString, expect);
    }

    @DataProvider(name = "a")
    public Object[][] provide() {
        return new Object[][]{
                new Object[]{"1", "[1]"},
                new Object[]{"1+3", "[4]"},
                new Object[]{"2-1-1", "[2,0]"},
                new Object[]{"2*3-4*5", "[-34,-10,-14,-10,10]"},
        };
    }
}