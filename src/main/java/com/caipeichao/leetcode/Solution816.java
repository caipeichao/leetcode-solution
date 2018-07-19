package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution816 {
    public List<String> ambiguousCoordinates(String s) {
        s = removeBracket(s);
        List<String> result = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            result.addAll(splitAt(s, i));
        }
        return result;
    }

    private String removeBracket(String s) {
        if (!s.startsWith("(")) throw new RuntimeException();
        if (!s.endsWith(")")) throw new RuntimeException();
        return s.substring(1, s.length() - 1);
    }

    private List<String> splitAt(String s, int pos) {
        String left = s.substring(0, pos);
        List<String> leftNumbers = addDot(left);
        if (leftNumbers.isEmpty()) return new ArrayList<>();
        String right = s.substring(pos);
        List<String> rightNumbers = addDot(right);
        if (rightNumbers.isEmpty()) return new ArrayList<>();
        return product(leftNumbers, rightNumbers);
    }

    private List<String> addDot(String s) {
        List<String> result = new ArrayList<>();
        result.add(s);
        for (int i = 1; i < s.length(); i++) {
            result.add(s.substring(0, i) + "." + s.substring(i));
        }
        return removeBadNumber(result);
    }

    private List<String> removeBadNumber(List<String> numbers) {
        return numbers.stream().filter(this::isOkNumber).collect(Collectors.toList());
    }

    private boolean isOkNumber(String s) {
        if (s.isEmpty()) return false;
        if (s.equals("0")) return true;
        boolean containsDot = s.contains(".");
        if (!containsDot) {
            if (s.startsWith("0")) return false;
        } else {
            if (s.endsWith("0")) return false;
            if (s.startsWith("0") && s.charAt(1) != '.') return false;
        }
        return true;
    }

    private List<String> product(List<String> left, List<String> right) {
        List<String> result = new ArrayList<>();
        for (String a : left) {
            for (String b : right) {
                result.add("(" + a + ", " + b + ")");
            }
        }
        return result;
    }
}
