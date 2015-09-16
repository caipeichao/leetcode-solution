package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();

        // 生成数字
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // 生成不同种类的二叉树结构
        return generateTrees(nums);
    }

    private List<TreeNode> generateTrees(List<Integer> nums) {
        // 如果没有节点，就返回一个空的列表
        if (nums.isEmpty()) {
            return new ArrayList<TreeNode>();
        }

        // 如果只剩一个节点了，让这一个节点构成一棵树就行了
        if (nums.size() == 1) {
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(new TreeNode(nums.get(0)));
            return result;
        }

        // 如果有多个节点，就让数字分到两边
        Integer root = nums.get(0);
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        right.addAll(nums);
        right.remove(0);
        List<TreeNode> result = new ArrayList<TreeNode>();
        while (true) {
            // 分别生成左右两边的树的形状
            List<TreeNode> leftPatterns = generateTrees(left);
            if (leftPatterns.isEmpty()) leftPatterns.add(null);
            List<TreeNode> rightPatterns = generateTrees(right);
            if (rightPatterns.isEmpty()) rightPatterns.add(null);

            // 两边的形状进行组合
            for (TreeNode leftNode : leftPatterns) {
                for (TreeNode rightNode : rightPatterns) {
                    TreeNode rootNode = new TreeNode(root);
                    rootNode.left = leftNode;
                    rootNode.right = rightNode;
                    result.add(rootNode);
                }
            }

            // 将右边一个节点分到左边
            if (right.isEmpty()) break;
            int lastIndex = right.size() - 1;
            Integer last = right.get(lastIndex);
            right.remove(last);
            left.add(0, last);
        }
        return result;
    }
}
