package com.caipeichao.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution326_2 {
    private static Set<Integer> li = new HashSet<Integer>();

    static {
        li.add(1);
        li.add(3);
        li.add(9);
        li.add(27);
        li.add(81);
        li.add(243);
        li.add(729);
        li.add(2187);
        li.add(6561);
        li.add(19683);
        li.add(59049);
        li.add(177147);
        li.add(531441);
        li.add(1594323);
        li.add(4782969);
        li.add(14348907);
        li.add(43046721);
        li.add(129140163);
        li.add(387420489);
        li.add(1162261467);
    }

    public boolean isPowerOfThree(int n) {
        return li.contains(n);
    }
}

