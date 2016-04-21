package com.caipeichao.leetcode;

public class Solution318 {
    public int maxProduct(String[] words) {
        if (words.length < 2) return 0;
        int n = words.length;
        int max = 0;
        int[] bits = bits(words);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bits[i] & bits[j]) != 0) continue;
                max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }

    private int[] bits(String[] words) {
        int[] result = new int[words.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = bits(words[i]);
        }
        return result;
    }

    private int bits(String word) {
        int n = word.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int c = word.charAt(i) - 'a';
            result |= 1 << c;
        }
        return result;
    }
}
