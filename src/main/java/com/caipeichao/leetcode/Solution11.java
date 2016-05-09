package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/8/28.
 */
public class Solution11 {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                int height = Math.min(heights[i], heights[j]);
                int width = j - i;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}

