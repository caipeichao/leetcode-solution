package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caipeichao on 15/7/13.
 */
public class Solution235_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;k˚
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if(p.val < root.val && q.val > root.val) {
                return root;
            } else if(p.val > root.val && q.val < root.val) {
                return root;
            } else if(p.val == root.val || q.val == root.val) {
                return root;
            } else {
                throw new RuntimeException("Impossible");
            }
        }
    }
}
