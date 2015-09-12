package com.caipeichao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution279 {
    private static Map<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int numSquares(int n) {
        // 从缓存中取出答案
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;
        Integer fromCache = cache.get(n);
        if (fromCache != null) return fromCache;

        // 缓存取不到，计算答案
        int i = (int) Math.ceil(Math.sqrt(n));
        int result = Integer.MAX_VALUE;
        for (; i >= 1; i--) {
            int remain = n - i * i;
            if (remain < 0) continue;
            if (remain == 0) return 1;
            result = Math.min(result, numSquares(remain) + 1);
        }
        cache.put(n, result);
        return result;
    }
}

