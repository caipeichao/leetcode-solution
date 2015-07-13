package com.caipeichao.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caipeichao on 15/6/23.
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null) return false;
        Set<Integer> set = new HashSet<Integer>();
        for (int a : nums) {
            if (!set.add(a)) {
                return true;
            }
        }
        return false;
    }
}
