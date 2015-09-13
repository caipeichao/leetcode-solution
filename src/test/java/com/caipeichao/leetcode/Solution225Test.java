package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution225Test {

    @Test
    public void t() {
        Solution225 a=new Solution225();
        a.push(1);
        a.push(2);
        assertEquals(a.top(),2);
        a.pop();
        assertEquals(a.top(),1);
        a.pop();
    }
}