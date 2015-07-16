package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/7/16.
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int length) {
        if (length == 1) {
            TreeNode result = new TreeNode(nums[start]);
            return result;
        } else if (length == 2) {
            TreeNode result = new TreeNode(nums[start]);
            result.right = new TreeNode(nums[start + 1]);
            return result;
        } else {
            int midIndex = length / 2 + start;
            int leftStart = start;
            int leftLength = length / 2;
            int rightStart = midIndex + 1;
            int rightLength = length - leftLength - 1;
            int midNum = nums[midIndex];
            TreeNode result = new TreeNode(midNum);
            result.left = sortedArrayToBST(nums, leftStart, leftLength);
            result.right = sortedArrayToBST(nums, rightStart, rightLength);
            return result;
        }
    }
}
