package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by caipeichao on 15/8/21.
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(nums);
        return result;
    }
}
