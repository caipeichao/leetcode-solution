package com.caipeichao.leetcode;

public class Solution309 {
    public int maxProfit(int[] prices) {
        // special case
        if (prices.length == 0) return 0;
        if (prices.length == 1) return 0;

        // main loop
        int inclusive = 0; // may include current profit
        int exclusive = 0; // not include current profit
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            int newInclusive = Math.max(inclusive + profit, exclusive);
            int newExclusive = Math.max(inclusive, exclusive);
            inclusive = newInclusive;
            exclusive = newExclusive;
        }

        // return result
        return Math.max(inclusive, exclusive);
    }
}

