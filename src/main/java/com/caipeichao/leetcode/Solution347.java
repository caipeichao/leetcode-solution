package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by caipeichao on 16/5/9.
 */
public class Solution347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 检查参数
        if (nums == null) return new ArrayList<Integer>();
        if (k == 0) return new ArrayList<Integer>();
        if (nums.length == 0) return new ArrayList<Integer>();

        // 对数组进行排序
        Arrays.sort(nums);

        // 统计每个元素的个数
        int lastElement = nums[0];
        int elementCount = 0;
        List<Element> list = new ArrayList<Element>();
        for (int e : nums) {
            if (e == lastElement) {
                elementCount++;
            } else {
                list.add(new Element(lastElement, elementCount));
                lastElement = e;
                elementCount = 1;
            }
        }
        list.add(new Element(lastElement, elementCount));

        // 获取数量最多的k个元素
        Collections.sort(list, new BigElement());
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            result.add(list.get(i).element);
        }
        return result;
    }

    private static class Element {
        private int element;
        private int elementCount;

        public Element(int lastElement, int elementCount) {
            this.element = lastElement;
            this.elementCount = elementCount;
        }
    }

    private static class BigElement implements Comparator<Element> {
        @Override
        public int compare(Element o1, Element o2) {
            return o2.elementCount - o1.elementCount;
        }
    }
}
