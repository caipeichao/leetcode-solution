package com.caipeichao.leetcode;

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        Return result = internal(root, k);
        return result.value;
    }

    public Return internal(TreeNode root, int k) {
        if (root == null) return returnNotFound(0);
        int scanCount = 0;
        if (root.left != null) {
            Return r = internal(root.left, k);
            if (r.found) {
                return r;
            } else {
                scanCount += r.count;
            }
        }
        if (k - scanCount == 1) {
            return returnFound(root.val);
        }
        scanCount += 1;
        if (root.right != null) {
            Return r = internal(root.right, k - scanCount);
            if (r.found) {
                return r;
            } else {
                scanCount += r.count;
            }
        }
        return returnNotFound(scanCount);
    }

    private Return returnFound(int value) {
        Return result = new Return();
        result.found = true;
        result.value = value;
        return result;
    }

    private Return returnNotFound(int count) {
        Return result = new Return();
        result.found = false;
        result.count = count;
        return result;
    }

    private static class Return {
        public int value;
        public int count;
        public boolean found;
    }
}
