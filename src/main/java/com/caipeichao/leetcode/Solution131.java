package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        // 空字符串只有一种组合
        if (s == null) return new ArrayList<List<String>>();
        if (s.isEmpty()) {
            List<List<String>> result = new ArrayList<List<String>>();
            result.add(new ArrayList<String>());
            return result;
        }

        // 只需要判断头部有没有对称的，后面的递归就行了
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 1; i <= s.length(); i++) {
            // 头部是对称的
            String head = s.substring(0, i);
            if (!isPalindrome(head)) continue;

            // 剩余部分递归
            String remain = s.substring(i);
            if(remain.isEmpty()) {
                List<String> p = new ArrayList<String>();
                p.add(head);
                result.add(p);
                continue;
            }
            List<List<String>> remainPartition = partition(remain);
            for (List<String> item : remainPartition) {
                item.add(0, head);
            }
            result.addAll(remainPartition);
        }

        return result;
    }

    public boolean isPalindrome(String s) {
        if (s == null) return true;
        if (s.isEmpty()) return true;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
