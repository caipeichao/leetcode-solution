package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution80Test {

    @Test
    public void testRemoveDuplicates() throws Exception {
        int[] input = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7};
        int length =  new Solution80().removeDuplicates(input);
        assertEquals(length, 13);
        assertEquals(toString(input), "11223345566772222233333333455555555667777");
    }

    private String toString(int[] nums) {
        StringBuilder result = new StringBuilder();
        for (int e : nums) {
            result.append(e);
        }
        return result.toString();
    }
}