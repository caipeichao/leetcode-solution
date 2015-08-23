package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by caipeichao on 15/8/21.
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        arraySort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(asList(nums));
        while (true) {
            boolean hasNext = nextPermute(nums);
            if (!hasNext) {
                break;
            }
            result.add(asList(nums));
        }
        return result;
    }

    private void arraySort(int[] array) {
        arraySort(array, 0, array.length);
    }

    private void arraySort(int[] array, int start, int end) {
        Arrays.sort(array, start, end);
    }

    private List<Integer> asList(int[] array) {
        List<Integer> result = new ArrayList<Integer>(array.length);
        for (int e : array) {
            result.add(e);
        }
        return result;
    }

    private boolean nextPermute(int[] nums) {
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    arraySwap(nums, i, j);
                    arraySort(nums, i + 1, nums.length);
                    return true;
                }
            }
        }
        return false;
    }

    private void arraySwap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
