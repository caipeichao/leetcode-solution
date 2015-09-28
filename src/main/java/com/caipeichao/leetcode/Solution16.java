package com.caipeichao.leetcode;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        // 特殊情况，数字不足三个
        if (nums.length < 3) throw new RuntimeException();

        // 先求出前三个数字的和
        int sum = nums[0] + nums[1] + nums[2];
        int[] selected = new int[]{0, 1, 2};

        // 遍历每个数，依次尝试找到更加接近的三个数字的和
        for (int i = 0; i < nums.length; i++) {
            // 寻找最大改善的位置
            int maxImprove = Integer.MIN_VALUE;
            int improveSelect = -1;
            int improveNum = -1;
            for (int k = 0; k < nums.length; k++) {
                if (contains(selected, k)) continue;
                for (int j = 0; j < selected.length; j++) {
                    int oldDiff = Math.abs(sum - target);
                    int newSum = sum - nums[selected[j]] + nums[k];
                    int newDiff = Math.abs(newSum - target);
                    int improve = oldDiff - newDiff;
                    if (improve > maxImprove) {
                        maxImprove = improve;
                        improveSelect = j;
                        improveNum = k;
                    }
                }
            }

            // 如果找到了替换后可以改善的数，就替换
            if (maxImprove > 0) {
                sum = sum - nums[selected[improveSelect]] + nums[improveNum];
                selected[improveSelect] = improveNum;
            }
        }

        // 遍历完成，已经找到最接近的求和了
        return sum;
    }

    private boolean contains(int[] list, int x) {
        for (int e : list) {
            if (e == x) return true;
        }
        return false;
    }
}
