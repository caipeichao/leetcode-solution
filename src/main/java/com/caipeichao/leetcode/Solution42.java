package com.caipeichao.leetcode;

public class Solution42 {
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        // 找到最大的高度
        int maxHeight = max(height);

        // 找出最左
        int[] maxLeft = new int[maxHeight];
        int lastLeftMaxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            for (int j = lastLeftMaxHeight; j < h; j++) {
                maxLeft[j] = i;
            }
            lastLeftMaxHeight = Math.max(lastLeftMaxHeight, h);
        }

        // 找出最右
        int[] maxRight = new int[maxHeight];
        int lastRightMaxHeight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            int h = height[i];
            for (int j = lastRightMaxHeight; j < h; j++) {
                maxRight[j] = i;
            }
            lastRightMaxHeight = Math.max(lastRightMaxHeight, h);
        }

        // 每层都遍历一遍
        int result = 0;
        for (int i = 0; i < maxHeight; i++) {
            for (int j = maxLeft[i]; j <= maxRight[i]; j++) {
                if (height[j] <= i) {
                    result++;
                }
            }
        }
        return result;
    }

    private int max(int[] li) {
        int result = li[0];
        for (int e : li) {
            result = Math.max(result, e);
        }
        return result;
    }
}
