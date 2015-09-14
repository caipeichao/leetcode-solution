package com.caipeichao.leetcode;

public class Solution190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long m = n;
        if (m < 0) m += 0x100000000L;

        int result = 0;
        int bitLength = 32;
        for (int i = 0; i < bitLength; i++) {
            result = result << 1;
            result |= n & 1;
            n = n >>> 1;
        }
        return result;
    }

}

