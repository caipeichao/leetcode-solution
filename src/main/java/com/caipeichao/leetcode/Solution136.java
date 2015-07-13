package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/6/22.
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        assert nums != null;

        int result = 0;
        for (int e : nums) {
            result = result ^ e;
        }
        return result;
    }
}
