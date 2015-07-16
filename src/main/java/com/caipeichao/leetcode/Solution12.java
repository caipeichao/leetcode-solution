package com.caipeichao.leetcode;

/**
 * Created by caipeichao on 15/7/16.
 */
public class Solution12 {
    private static class Symbol {
        public int value;
        public String text;

        public Symbol(int value, String text) {
            this.value = value;
            this.text = text;
        }
    }

    public String intToRoman(int num) {
        Symbol s1000 = new Symbol(1000, "M");
        Symbol s500 = new Symbol(500, "D");
        Symbol s100 = new Symbol(100, "C");
        Symbol s50 = new Symbol(50, "L");
        Symbol s10 = new Symbol(10, "X");
        Symbol s5 = new Symbol(5, "V");
        Symbol s1 = new Symbol(1, "I");

        StringBuilder result = new StringBuilder();
        num = consume(num, s1000, s100, result);
        num = consume(num, s500, s100, result);
        num = consume(num, s100, s10, result);
        num = consume(num, s50, s10, result);
        num = consume(num, s10, s1, result);
        num = consume(num, s5, s1, result);
        num = consume(num, s1, null, result);
        return result.toString();
    }

    private int consume(int input, Symbol big, Symbol small, StringBuilder out) {
        while (input >= big.value) {
            out.append(big.text);
            input -= big.value;
        }
        if (small == null) return input;
        if (input >= big.value - small.value) {
            out.append(small.text);
            out.append(big.text);
            return input - (big.value - small.value);
        }
        return input;
    }
}
