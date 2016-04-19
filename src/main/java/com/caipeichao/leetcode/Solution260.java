package com.caipeichao.leetcode;

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        // 使用xor进行求和
        int sum1 = 0;
        int sum2 = 0;
        for (int e : nums) {
            sum1 ^= e;
            sum2 ^= e * e;
        }

        // 依次检查当前值是否只有一个
        int[] result = new int[2];
        for (int e : nums) {
            int x = e; // 假设这是要找的一个数值
            int y = sum1 ^ e; // 假设这是另外一个需要找的数值

            // 通过sum2验证这两个值是不是要找的值
            if (((x * x) ^ (y * y)) == sum2) {
                result[0] = x;
                result[1] = y;
                return result;
            }
        }
        throw new RuntimeException("not found");
    }
}
