package com.caipeichao.leetcode;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class Solution297Test {
    @Test
    public void test() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        a3.left = a2;
        a3.right = a4;
        a2.left = a1;
        String s = new Solution297().new Codec().serialize(a3);
        new Solution297().new Codec().deserialize(s);
    }
}