package com.caipeichao.leetcode;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        // 二分查找
        Return r = bisect(nums, target);
        if (!r.found) {
            return new int[]{-1, -1};
        }

        // 寻找边界值作为结果
        int start = findLeft(nums, target, r.start, r.index + 1);
        int end = findRight(nums, target, r.index, r.end);
        return new int[]{start, end};
    }

    private int findLeft(int[] nums, int target, int start, int end) {
        while (true) {
            // 剩余的长度很小了
            int length = end - start;
            if (length < 5) {
                for (int i = start; i < end; i++) {
                    if (nums[i] == target) {
                        return i;
                    }
                }
                throw new RuntimeException();
            }

            // 二分法
            int mid = start + (length - 1) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                end = mid + 1;
            } else if (midNum < target) {
                start = mid;
            } else if (target < midNum) {
                end = mid + 1;
            }
        }
    }

    private int findRight(int[] nums, int target, int start, int end) {
        while (true) {
            // 剩余长度已经很小了
            int length = end - start;
            if (length < 5) {
                for (int i = end - 1; i >= start; i--) {
                    if (nums[i] == target) {
                        return i;
                    }
                }
                throw new RuntimeException();
            }

            // 二分法
            int mid = start + (length - 1) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                start = mid;
            } else if (target < midNum) {
                end = mid + 1;
            } else if (midNum < target) {
                start = mid;
            }
        }
    }

    private Return bisect(int[] nums, int target) {
        // 没有数据
        if (nums.length == 0) {
            return notFound();
        }

        // 二分查找
        int start = 0;
        int end = nums.length;
        while (true) {
            // 剩余长度已经很小了
            int length = end - start;
            if (length < 5) {
                for (int i = start; i < end; i++) {
                    if (nums[i] == target) {
                        return found(i, start, end);
                    }
                }
                return notFound();
            }

            // 二分
            int mid = start + (length - 1) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return found(mid, start, end);
            } else if (midNum < target) {
                start = mid;
            } else if (target < midNum)
                end = mid + 1;
        }
    }

    private Return notFound() {
        return new Return();
    }

    private Return found(int index, int start, int end) {
        Return r = new Return();
        r.found = true;
        r.index = index;
        r.start = start;
        r.end = end;
        return r;
    }

    public static class Return {
        public boolean found;
        public int index;
        public int start;
        public int end;
    }
}

