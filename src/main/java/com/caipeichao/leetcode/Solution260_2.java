package com.caipeichao.leetcode;

public class Solution260_2 {
    public int[] singleNumber(int[] nums) {
        // 求出a^b
        int aXorb = 0;
        for (int e : nums) aXorb ^= e;

        // 求出最后一个不一样的bit
        int lastDiffBit = aXorb & ~(aXorb - 1);

        // 根据最后一个不一样的bit对数字进行分类
        int[] result = new int[2];
        for (int e : nums) {
            if ((e & lastDiffBit) == 0) result[0] ^= e;
            else result[1] ^= e;
        }

        // 返回结果
        return result;
    }
}

