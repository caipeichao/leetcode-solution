package com.caipeichao.leetcode;

public class Solution318 {
    public int maxProduct(String[] words) {
        // check params
        if (words.length < 2) return 0;

        // calculate word bits
        int n = words.length;
        int[] bits = new int[n];
        for (int i = 0; i < bits.length; i++) {
            String word = words[i];
            int wl = word.length();
            int bit = 0;
            for (int j = 0; j < wl; j++) {
                int c = word.charAt(j) - 'a';
                bit |= 1 << c;
            }
            bits[i] = bit;
        }

        // brute force find max words
        int max = 0;
        for (int i = 0; i < n; i++) {
            int bitsi = bits[i];
            int wordsilength = words[i].length();
            for (int j = i + 1; j < n; j++) {
                if ((bitsi & bits[j]) != 0) continue;
                max = Math.max(max, wordsilength * words[j].length());
            }
        }
        return max;
    }
}

