package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution736Test {
    @Test
    public void test() {
        Solution736 a = new Solution736();
        System.out.println(a.evaluate("(add (let x 1 y 2 (add x y)) 0)"));
    }
}