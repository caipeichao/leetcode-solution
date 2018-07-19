package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Solution307 {
    public static void main(String[] argv) {
        new Solution307().run();
    }

    private void run() {
//        NumArray a = new NumArray(new int[]{1, 3, 5});
//        System.out.println(a.sumRange(0, 2));
//        a.update(1, 2);
//        System.out.println(a.sumRange(0, 2));

        System.out.println(Slice.createAlign(1,100001));

        NumArray a = new NumArray(randomArray(100200));
        System.out.println(a.sumRange(0, 100000));
        a.update(1, 2);
        System.out.println(a.sumRange(1, 100001));
        System.out.println(a.sumRange(2, 100002));
        System.out.println(a.sumRange(3, 100003));
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
        private int[] nums;
        private Map<Slice, Integer> cache;
        private static final boolean DEBUG = false;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.cache = new HashMap<>();
        }

        public void update(int i, int val) {
            int delta = val - nums[i];
            this.nums[i] = val;
            updateCache(i, delta);
        }

        public int sumRange(int i, int j) {
            List<Slice> slices = Slice.createAlign(i, j + 1);
            int result = 0;
            for (Slice slice : slices) {
                result += sumWithCache(slice);
            }
            return result;
        }

        private void updateCache(int i, int delta) {
            for (Slice slice : Slice.getAlignSlices(i)) {
                cache.computeIfPresent(slice, (key, oldValue) -> oldValue + delta);
            }
        }

        private int sumWithCache(Slice slice) {
            if (!slice.isAlign()) return sumWithoutCache(slice);
            Integer result = cache.get(slice);
            if (result != null) {
                if(DEBUG) System.out.println("Cache hit: " + slice);
                return result;
            }
            result = sumWithoutCache(slice);
            cache.put(slice, result);
            return result;
        }

        private int sumWithoutCache(Slice slice) {
            if(DEBUG) System.out.println("Cache not hit: " + slice);
            if (!slice.isAlign() || slice.isSmallestAlignSlice()) return sumWithBruteForce(slice);
            List<Slice> slices = slice.breakIntoAlignSlices();
            int result = 0;
            for (Slice e : slices) {
                result += sumWithCache(e);
            }
            return result;
        }

        private int sumWithBruteForce(Slice slice) {
            if(DEBUG) System.out.println("brute force: " + slice);
            int result = 0;
            for (int i = slice.start; i < slice.end; i++) {
                result += nums[i];
            }
            return result;
        }
    }

    static class Slice {
        public final int start;
        public final int end;

        public boolean isAlign() {
            int length = length();
            if (start % length != 0) return false;
            for (int level : levels) {
                if (level == length) return true;
            }
            return false;
        }

        public Slice(int start, int end) {
            if (start >= end) throw new RuntimeException("Bad range: " + start + "," + end);
            this.start = start;
            this.end = end;
        }

        private static final int SLICE_SIZE = 100;
        private static final int[] levels;

        @Override
        public String toString() {
            return String.format("%s,%s", start, end);
        }

        static {
            levels = getSliceLevels();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Slice)) return false;
            Slice slice = (Slice) o;
            return start == slice.start &&
                    end == slice.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        private static int[] getSliceLevels() {
            List<Integer> levels = new ArrayList<>();
            int level = SLICE_SIZE;
            levels.add(level);
            while (true) {
                int higherLevel = level * SLICE_SIZE;
                if (higherLevel / SLICE_SIZE != level) break;
                level = higherLevel;
                levels.add(level);
            }
            Collections.reverse(levels);
            return levels.stream().mapToInt((x) -> x).toArray();
        }

        public static List<Slice> createAlign(int i, int j) {
            List<Slice> result = new ArrayList<>();
            int current = i;
            while (true) {
                Slice slice = getNextSlice(current, j);
                if (slice == null) break;
                current = slice.end;
                result.add(slice);
            }
            return result;
        }

        private static Slice getNextSlice(int start, int end) {
            if (start == end) return null;
            Slice[] alignSlices = getAlignSlices(start);
            for (Slice slice : alignSlices) {
                if (slice.start == start && slice.end <= end) {
                    return slice;
                }
            }
            int resultEnd = nextAlignPointExclusive(start, SLICE_SIZE);
            resultEnd = Math.min(resultEnd, end);
            return new Slice(start, resultEnd);
        }

        private static int nextAlignPointExclusive(int i, int sliceSize) {
            return i - i % sliceSize + sliceSize;
        }

        private static int previousAlignPointInclusive(int i, int sliceSize) {
            return i - i % sliceSize;
        }

        public static Slice[] getAlignSlices(int point) {
            Slice[] result = new Slice[levels.length];
            for (int i = 0; i < result.length; i++) {
                int level = levels[i];
                int start = previousAlignPointInclusive(point, level);
                int end = nextAlignPointExclusive(point, level);
                result[i] = new Slice(start, end);
            }
            return result;
        }

        public List<Slice> breakIntoAlignSlices() {
            if (!isAlign()) throw new RuntimeException("require align");
            if (isSmallestAlignSlice()) throw new RuntimeException("cannot break smallest slice");
            int lowerLevel = length() / SLICE_SIZE;
            List<Slice> result = new ArrayList<>();
            for (int i = start; i < end; i += lowerLevel) {
                result.add(new Slice(i, i + lowerLevel));
            }
            return result;
        }

        public int length() {
            return end - start;
        }

        public boolean isSmallestAlignSlice() {
            return length() == SLICE_SIZE;
        }
    }

}