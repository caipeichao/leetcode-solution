package com.caipeichao.leetcode;

public class Solution345 {
    public String reverseVowels(String s) {
        // 拆分成字符
        char[] chars = s.toCharArray();

        // 找出元音字符
        boolean[] vowel = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            vowel[i] = isVowel(chars[i]);
        }

        // 提取元音字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (vowel[i]) {
                sb.append(chars[i]);
            }
        }

        // 反转元音字符
        sb.reverse();

        // 反转后填入原位
        int vowelIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!vowel[i]) continue;
            chars[i] = sb.charAt(vowelIndex);
            vowelIndex++;
        }

        // 组合单个字符变成字符串
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) >= 0;
    }
}
