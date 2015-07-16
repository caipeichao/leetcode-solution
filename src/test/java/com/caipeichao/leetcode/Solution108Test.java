package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution108Test {
    @Test
    public void test() {
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        TreeNode result = new Solution108().sortedArrayToBST(a);
        print(result);
    }

    private void print(TreeNode node) {
        if(node==null) {
            System.out.println("N");
            return;
        }
        System.out.println(node.val);
        print(node.left);
        print(node.right);
    }
}