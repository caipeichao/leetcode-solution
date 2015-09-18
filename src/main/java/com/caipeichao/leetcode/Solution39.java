package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, 0);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = start; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            if (newTarget == 0) {
                List<Integer> s = new ArrayList<Integer>();
                s.add(candidates[i]);
                result.add(s);
            }
            if (newTarget < 0) {
                return result;
            }

            // 递归调用
            List<List<Integer>> subResult = combinationSum(candidates, newTarget, i);
            for (List<Integer> e : subResult) {
                e.add(0, candidates[i]);
            }
            result.addAll(subResult);
        }
        return result;
    }
}

