package com.caipeichao.leetcode;

public class Solution4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length == 0 && nums2.length == 0) {
                throw new RuntimeException("bad error");
            }
            return find(nums1, nums2);
        }

        private boolean isOdd(int n) {
            return (n % 2) == 1;
        }

        private double average(int a, int b) {
            return (a + b) / 2.0;
        }

        private double find(int[] nums1, int[] nums2) {
            int n = nums1.length + nums2.length;
            if (isOdd(n)) {
                return findKth(nums1, nums2, n / 2);
            } else {
                return average(findKth(nums1, nums2, n / 2 - 1), findKth(nums1, nums2, n / 2));
            }
        }

        private int findKth(int[] nums1, int[] nums2, int n) {
            if (nums1.length == 0) {
                return findKth(nums2, n);
            } else if (nums2.length == 0) {
                return findKth(nums1, n);
            } else {
                return findKthDoubleArray(nums1, nums2, n);
            }
        }

        private int findKth(int[] nums, int n) {
            return nums[n];
        }

        private int findKthDoubleArray(int[] nums1, int[] nums2, int i) {
            if (i == 0) {
                return Math.min(nums1[0], nums2[0]);
            }
            Range r1 = new Range(0, i);
            while (true) {
                int i1 = r1.mid();
                int i2 = i - i1;
                int v1 = nums1[i1];
                int v2 = nums2[i2];
                if (v1 == v2) {
                    return v1;
                }
                if (v1 < v2) {
                    r1 = r1.rightHalf();
                } else {
                    r1 = r1.leftHalf();
                }
                if (r1.length() == 0) {
                    throw new RuntimeException("range cannot be empty");
                }
                if (r1.length() == 1) {
                    
                }
            }


            int m1 = g1.midValue();
            int m2 = g2.midValue();
            if (m1 == m2) {

            } else if (m1 < m2) {

            } else if (m1 > m2) {

            }

            // 1 2 3 4 5 6 7 8 9
            // 1 2 3 4 5 6 7 8 9

            // ? ? ? ? 1 ? ? ? ?
            // ? ? ? ? 1 ? ? ? ?
            // 9th 10th is 1

            // 0 0 0 1 1 3 5 5 6 7 7 7 8 8 8 8 8 8 8 9
            // 0 1 2 2 2 2 5 5 5 6 6 6 6 7 7 8 8 8 8 9

            /*
            find 9th
            ? ? ? ? ? ? ? ? 6 ? ? ? ? ? ? ? ? ? ? ?
            0 ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
            nums1[8]=6, nums2[0]=0, fail

            ? ? ? 1 ? ? ? ? 6 ? ? ? ? ? ? ? ? ? ? ?
            0 ? ? ? 2 ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
            nums1[3]=1, nums2[4]=2, fail

            ? ? ? 1 ? 3 ? ? 6 ? ? ? ? ? ? ? ? ? ? ?
            0 ? 2 ? 2 ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
            nums1[2]=3, nums2[5]=2, fail

            ? ? ? 1>1<3 ? ? 6 ? ? ? ? ? ? ? ? ? ? ?
            0 ? 2>2<2 ? ? ? ? ? ? ? ? ? ? ? ? ? ? ?
            nums1[4]=1, nums2[3]=2, result 2
             */
        }
    }

    class Range {
        private final int start;
        private final int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
