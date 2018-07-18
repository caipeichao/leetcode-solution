package com.caipeichao.leetcode;

import org.testng.annotations.Test;

public class Solution808Test {
    @Test
    public void test() {
        for(int i=1;i<50000;i++) {
            System.out.println(i + "," + new Solution808().soupServings(i));
        }
    }
}