package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/6/22.
 */
public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bitCount = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                bitCount++;
            }
            n = n >>> 1;
        }
        return bitCount;
    }
}
