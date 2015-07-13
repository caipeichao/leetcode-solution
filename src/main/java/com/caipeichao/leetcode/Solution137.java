package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/7/5.
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int e : nums) {
            int a2 = a;
            int b2 = b;

            int if1 = (~a2 & ~b2) & e; // if a = 0 and b = 0 and e = 1
            a = a | if1; // a = 1
            b = b & ~if1; // b = 0

            int if2 = (a2 & ~b2) & e; // if a = 1 and b = 0 and e = 1
            a = a & ~if2; // a = 0
            b = b | if2; // b = 1

            int if3 = (~if1) & (~if2) & e; // else e = 1
            a = a & ~if3; // a = 0
            b = b & ~if3; // b = 0
        }
        return a;
    }
}
