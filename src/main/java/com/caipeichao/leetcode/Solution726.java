package com.caipeichao.leetcode;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution726 {
    public String countOfAtoms(String formula) {
        CharBuffer buffer = CharBuffer.wrap(formula.toCharArray());
        Token formulaToken = readFormula(buffer);
        return formulaToken.countOfAtoms().toString();
    }

    private FormulaToken readFormula(CharBuffer buffer) {
        FormulaToken result = new FormulaToken();
        while (true) {
            Token token;
            token = readAtomAndCount(buffer);
            if (token != null) {
                result.add(token);
                continue;
            }
            token = readGroupAndCount(buffer);
            if (token != null) {
                result.add(token);
                continue;
            }
            break;
        }
        return result;
    }

    private GroupAndCountToken readGroupAndCount(CharBuffer buffer) {
        GroupToken groupToken = readGroup(buffer);
        if (groupToken == null) return null;
        CountToken countToken = readCount(buffer);
        return new GroupAndCountToken(groupToken, countToken);
    }

    private GroupToken readGroup(CharBuffer buffer) {
        Character leftBracket = readChar(buffer, '(');
        if (leftBracket == null) return null;
        FormulaToken formulaToken = readFormula(buffer);
        Character rightBracket = readChar(buffer, ')');
        if (rightBracket == null) throw new RuntimeException("unbalance");
        return new GroupToken(formulaToken);
    }

    private Character readChar(CharBuffer buffer, char c) {
        return readRequired(buffer, (x) -> x == c);
    }

    private static class GroupAndCountToken implements Token {
        private GroupToken group;
        private CountToken count;

        public GroupAndCountToken(GroupToken groupToken, CountToken countToken) {
            this.group = groupToken;
            if(countToken == null) countToken = new CountToken(1);
            this.count = countToken;
        }

        @Override
        public AtomCount countOfAtoms() {
            return group.countOfAtoms().multiply(count.getValue());
        }
    }

    private static class GroupToken implements Token {
        private FormulaToken formulaToken;

        public GroupToken(FormulaToken formulaToken) {
            this.formulaToken = formulaToken;
        }

        @Override
        public AtomCount countOfAtoms() {
            return formulaToken.countOfAtoms();
        }
    }

    private AtomAndCountToken readAtomAndCount(CharBuffer buffer) {
        AtomToken atomToken = readAtom(buffer);
        if(atomToken == null) return null;
        CountToken countToken = readCount(buffer);
        return new AtomAndCountToken(atomToken, countToken);
    }

    private CountToken readCount(CharBuffer buffer) {
        StringBuilder result = new StringBuilder();
        while (true) {
            Character c = readDigit(buffer);
            if (c == null) break;
            result.append(c);
        }
        if (result.length() == 0) return null;
        int value = Integer.parseInt(result.toString());
        return new CountToken(value);
    }

    private Character readRequired(CharBuffer buffer, Function<Character, Boolean> isQualified) {
        Character c = peek(buffer);
        if (c == null) return null;
        if (!isQualified.apply(c)) return null;
        buffer.get();
        return c;
    }

    private Character readDigit(CharBuffer buffer) {
        return readRequired(buffer, this::isDigit);
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private static class CountToken implements Token {
        private int value;

        public CountToken(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public AtomCount countOfAtoms() {
            throw new RuntimeException("bad");
        }
    }

    private AtomToken readAtom(CharBuffer buffer) {
        Character c1 = readUpperLetter(buffer);
        if (c1 == null) return null;
        StringBuilder atomString = new StringBuilder();
        atomString.append(c1.charValue());
        while (true) {
            Character c2 = readLowerLetter(buffer);
            if (c2 == null) break;
            atomString.append(c2.charValue());
        }
        return new AtomToken(atomString.toString());
    }

    private Character readLowerLetter(CharBuffer buffer) {
        return readRequired(buffer, this::isLowerLetter);
    }

    private boolean isLowerLetter(char c) {
        return 'a' <= c && c <= 'z';
    }

    private Character readUpperLetter(CharBuffer buffer) {
        return readRequired(buffer, this::isUpperLetter);
    }

    private Character peek(CharBuffer buffer) {
        if (buffer.position() >= buffer.limit()) return null;
        return buffer.array()[buffer.arrayOffset() + buffer.position()];
    }

    private boolean isUpperLetter(char c) {
        return 'A' <= c && c <= 'Z';
    }

    private static class AtomToken implements Token {
        private String name;

        public AtomToken(String name) {
            this.name = name;
        }

        @Override
        public AtomCount countOfAtoms() {
            Map<String, Integer> map = new HashMap<>();
            map.put(name, 1);
            return new AtomCount(map);
        }
    }

    private static class AtomAndCountToken implements Token {
        private AtomToken atomToken;
        private CountToken countToken;

        public AtomAndCountToken(AtomToken atomToken, CountToken countToken) {
            this.atomToken = atomToken;
            if(countToken == null) countToken = new CountToken(1);
            this.countToken = countToken;
        }

        @Override
        public AtomCount countOfAtoms() {
            return atomToken.countOfAtoms().multiply(countToken.getValue());
        }
    }

    private static class FormulaToken implements Token {
        private List<Token> tokens = new ArrayList<>();

        public void add(Token token) {
            this.tokens.add(token);
        }

        @Override
        public AtomCount countOfAtoms() {
            return tokens.stream().map(Token::countOfAtoms).reduce(AtomCount::add).orElse(new AtomCount(new HashMap<>()));
        }
    }

    public interface Token {
        AtomCount countOfAtoms();
    }

    public static class AtomCount {
        private final Map<String, Integer> counts;

        public AtomCount(Map<String, Integer> counts) {
            this.counts = counts;
        }

        @Override
        public String toString() {
            List<String> atoms = new ArrayList<>(counts.keySet());
            Collections.sort(atoms);
            return atoms.stream().map((x) -> {
                int count = counts.get(x);
                if(count > 1) {
                    return x + count;
                } else {
                    return x;
                }
            }).collect(Collectors.joining());
        }

        public AtomCount add(AtomCount that) {
            Map<String, Integer> map = new HashMap<>();
            map.putAll(this.counts);
            that.counts.forEach((key, value) -> {
                map.put(key, map.getOrDefault(key, 0) + value);
            });
            return new AtomCount(map);
        }

        public AtomCount multiply(int c) {
            Map<String, Integer> map = new HashMap<>();
            this.counts.forEach((key, value) -> {
                map.put(key, value * c);
            });
            return new AtomCount(map);
        }
    }
}