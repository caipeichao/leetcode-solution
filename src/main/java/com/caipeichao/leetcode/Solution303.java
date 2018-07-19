package com.caipeichao.leetcode;

import java.util.Random;

public class Solution303 {
    public static void main(String[] argv) {
        NumArray a = new NumArray(randomArray(100000));
        System.out.println(a.sumRange(0, 0));
        System.out.println(a.sumRange(0, 1));
        System.out.println(a.sumRange(0, 10000));
        System.out.println(a.sumRange(1, 10001));
        System.out.println(a.sumRange(2, 10002));
        System.out.println(a.sumRange(3, 10003));
        System.out.println(a.sumRange(4, 10004));
        System.out.println(a.sumRange(5, 10005));
    }

    private static int[] randomArray(int count) {
        int[] result = new int[count];
        Random random = new Random(42);
        for (int i = 0; i < count; i++) {
            result[i] = random.nextInt(10);
        }
        return result;
    }

    static class NumArray {
        private final int[] nums;
        private final SumNode root;
        private static final int MAX_NODE_LENGTH = 10;

        public NumArray(int[] nums) {
            this.nums = nums;
            root = buildIndex(nums);
        }

        private SumNode buildIndex(int[] nums) {
            return buildIndex(nums, 0, nums.length);
        }

        private SumNode buildIndex(int[] nums, int start, int end) {
            int length = end - start;
            if (length <= MAX_NODE_LENGTH) {
                return new SumLeafNode(start, end, sumArray(nums, start, end));
            }
            int mid = length / 2 + start;
            SumNode left = buildIndex(nums, start, mid);
            SumNode right = buildIndex(nums, mid, end);
            int sum = left.getSum() + right.getSum();
            return new SumMidNode(mid, sum, left, right);
        }

        public static int sumArray(int[] nums, int start, int end) {
            int result = 0;
            for (int i = start; i < end; i++) {
                result += nums[i];
            }
            return result;
        }

        public int sumRange(int i, int j) {
            int start = i;
            int end = j + 1;
            if (start == 0) start = SumNode.NULL;
            if (end == nums.length) end = SumNode.NULL;
            return root.sum(nums, start, end);
        }
    }

    interface SumNode {
        public int getSum();

        public int sum(int[] nums, int start, int end);

        public static final int NULL = -1;
    }

    static class SumLeafNode implements SumNode {
        private final int start;
        private final int end;
        private final int sum;

        public SumLeafNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }

        @Override
        public int getSum() {
            return sum;
        }

        @Override
        public int sum(int[] nums, int start, int end) {
            if (start == NULL) start = this.start;
            if (end == NULL) end = this.end;
            return NumArray.sumArray(nums, start, end);
        }
    }

    static class SumMidNode implements SumNode {
        private final int mid;
        private final int sum;
        private final SumNode left;
        private final SumNode right;

        public SumMidNode(int mid, int sum, SumNode left, SumNode right) {
            this.mid = mid;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }

        public int getMid() {
            return mid;
        }

        @Override
        public int getSum() {
            return sum;
        }

        @Override
        public int sum(int[] nums, int start, int end) {
            if (start == NULL && end == NULL) return sum;
            if (start == NULL) {
                if (end < mid) {
                    return left.sum(nums, start, end);
                } else if (mid < end) {
                    return left.getSum() + right.sum(nums, mid, end);
                } else {
                    return left.getSum();
                }
            }
            if (end == NULL) {
                if (start < mid) {
                    return left.sum(nums, start, NULL) + right.getSum();
                } else if (mid < start) {
                    return right.sum(nums, start, NULL);
                } else {
                    return right.getSum();
                }
            }
            if (start == end) return 0;
            if (end < start) throw new RuntimeException("end > start");
            if (end < mid) {
                return left.sum(nums, start, end);
            } else if (end == mid) {
                return left.sum(nums, start, NULL);
            } else if (mid < start) {
                return right.sum(nums, start, end);
            } else if (mid == start) {
                return right.sum(nums, NULL, end);
            } else {
                return left.sum(nums, start, NULL) + right.sum(nums, NULL, end);
            }
        }

        public SumNode getLeft() {
            return left;
        }

        public SumNode getRight() {
            return right;
        }
    }
}