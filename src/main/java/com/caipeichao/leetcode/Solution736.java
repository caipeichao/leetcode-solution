package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution736 {
    public static boolean isDigit(char c) {
        if (c == '-') return true;
        return '0' <= c && c <= '9';
    }

    public static boolean isLowerCaseLetter(char c) {
        return 'a' <= c && c <= 'z';
    }

    public int evaluate(String expression) {
        Token token = tokenize(expression);
        EvalContext context = new EvalContext(null);
        return token.eval(context);
    }

    private Token tokenize(String expression) {
        int n = expression.length();
        Tokenizer tokenizer = new ExpressionTokenizer();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (!tokenizer.feed(c)) {
                throw new RuntimeException("feed error");
            }
        }
        return tokenizer.end();
    }

    public interface Tokenizer {
        boolean feed(char c);

        Token end();
    }

    public interface Token {
        int eval(EvalContext context);

        public default SymbolToken asSymbolToken(String message) {
            if (this instanceof SymbolToken) return (SymbolToken) this;
            throw new RuntimeException(message);
        }
    }

    public static class EvalContext {
        private final EvalContext parent;
        private final Map<String, Integer> vars;

        public EvalContext(EvalContext parent) {
            this.parent = parent;
            this.vars = new HashMap<>();
        }

        public EvalContext getParent() {
            return parent;
        }

        public int getVar(String name) {
            Integer result = vars.get(name);
            if (result != null) return result;
            if (parent == null) throw new RuntimeException("var not found");
            return parent.getVar(name);
        }

        public void putVar(String name, int value) {
            this.vars.put(name, value);
        }
    }

    public static class ExpressionTokenizer implements Tokenizer {
        private Tokenizer subTokenizer;

        @Override
        public boolean feed(char c) {
            if (subTokenizer == null) {
                if (c == '(') {
                    subTokenizer = new BracketTokenizer();
                } else if (isDigit(c)) {
                    subTokenizer = new NumberTokenizer();
                } else if (isLowerCaseLetter(c)) {
                    subTokenizer = new SymbolTokenizer();
                } else {
                    throw new RuntimeException("Bad char: " + c);
                }
            }
            return subTokenizer.feed(c);
        }

        @Override
        public Token end() {
            return subTokenizer.end();
        }
    }

    public static class SymbolTokenizer implements Tokenizer {
        private StringBuilder stringBuilder = new StringBuilder();

        @Override
        public boolean feed(char c) {
            if (stringBuilder.length() == 0) {
                if (isLowerCaseLetter(c)) {
                    stringBuilder.append(c);
                    return true;
                } else {
                    return false;
                }
            } else {
                if (isLowerCaseLetter(c) || isDigit(c)) {
                    stringBuilder.append(c);
                    return true;
                } else {
                    return false;
                }
            }
        }

        @Override
        public Token end() {
            if (stringBuilder.length() == 0) throw new RuntimeException("bad");
            return new SymbolToken(stringBuilder.toString());
        }
    }

    public static class SymbolToken implements Token {
        private final String literal;

        public SymbolToken(String literal) {
            this.literal = literal;
        }

        @Override
        public int eval(EvalContext context) {
            return context.getVar(literal);
        }

        public String getLiteral() {
            return literal;
        }
    }

    public static class NumberTokenizer implements Tokenizer {
        private StringBuilder stringBuilder = new StringBuilder();

        @Override
        public boolean feed(char c) {
            if (!isDigit(c)) return false;
            stringBuilder.append(c);
            return true;
        }

        @Override
        public Token end() {
            String s = stringBuilder.toString();
            stringBuilder = null;
            if (s.isEmpty()) throw new RuntimeException("empty number");
            int value = Integer.parseInt(s);
            return new NumberToken(value);
        }
    }

    public static class NumberToken implements Token {
        private final int value;

        public NumberToken(int value) {
            this.value = value;
        }

        @Override
        public int eval(EvalContext context) {
            return value;
        }
    }

    public static class BracketTokenizer implements Tokenizer {
        private Tokenizer leftBracketTokenizer = new OneCharTokenizer('(');
        private Tokenizer expTokenizer;
        private Tokenizer spaceTokenizer = new SpaceTokenizer();
        private Tokenizer rightBracketTokenizer = new OneCharTokenizer(')');
        private List<Token> tokens = new ArrayList<>();

        private boolean feed(char c, boolean recursive) {
            if (rightBracketTokenizer == null) return false;
            if (leftBracketTokenizer != null) {
                if (leftBracketTokenizer.feed(c)) {
                    leftBracketTokenizer = null;
                    return true;
                }
                throw new RuntimeException("require left bracket");
            }
            if (expTokenizer == null) {
                if (rightBracketTokenizer.feed(c)) {
                    rightBracketTokenizer = null;
                    return true;
                }
                if (spaceTokenizer != null) {
                    if (spaceTokenizer.feed(c)) return true;
                }
                expTokenizer = new ExpressionTokenizer();
            }
            if (expTokenizer.feed(c)) return true;
            tokens.add(expTokenizer.end());
            expTokenizer = null;
            if (!recursive) return false;
            return feed(c, false);
        }

        @Override
        public boolean feed(char c) {
            return feed(c, true);
        }

        @Override
        public Token end() {
            if (leftBracketTokenizer != null) throw new RuntimeException("left bracket not feed");
            if (rightBracketTokenizer != null) throw new RuntimeException("right bracket not feed");
            if (expTokenizer != null) throw new RuntimeException("expression not feed");
            return new ListToken(tokens);
        }
    }

    public static class ListToken implements Token {
        private final List<Token> tokens;

        public ListToken(List<Token> tokens) {
            this.tokens = tokens;
        }

        public List<Token> getTokens() {
            return tokens;
        }

        @Override
        public int eval(EvalContext context) {
            if (tokens.isEmpty()) throw new RuntimeException("empty bracket");
            SymbolToken first = tokens.get(0).asSymbolToken("first token requires symbol");
            String literal = first.getLiteral();
            context = new EvalContext(context);
            if (literal.equals("let")) {
                return evalLet(context);
            } else if (literal.equals("add")) {
                return evalAdd(context);
            } else if (literal.equals("mult")) {
                return evalMulti(context);
            } else {
                throw new RuntimeException("Unknown command: " + literal);
            }
        }

        private int evalMulti(EvalContext context) {
            List<Token> tokens = getTokensExceptFirst();
            if (tokens.size() != 2) throw new RuntimeException("multi require 2 args");
            Token left = tokens.get(0);
            Token right = tokens.get(1);
            return left.eval(context) * right.eval(context);
        }

        private List<Token> getTokensExceptFirst() {
            return tokens.subList(1, tokens.size());
        }

        private int evalAdd(EvalContext context) {
            List<Token> tokens = getTokensExceptFirst();
            if (tokens.size() != 2) throw new RuntimeException("add requires 2 args");
            Token left = tokens.get(0);
            Token right = tokens.get(1);
            return left.eval(context) + right.eval(context);
        }

        private int evalLet(EvalContext context) {
            List<Token> tokens = this.tokens.subList(1, this.tokens.size() - 1);
            int length = tokens.size();
            if (length % 2 != 0) throw new RuntimeException("not pair");
            for (int i = 0; i < length; i += 2) {
                SymbolToken varName = tokens.get(i).asSymbolToken("var name should be a symbol");
                Token varValue = tokens.get(i + 1);
                context.putVar(varName.getLiteral(), varValue.eval(context));
            }
            if (this.tokens.size() <= 1) throw new RuntimeException("no last exp");
            Token last = this.tokens.get(this.tokens.size() - 1);
            return last.eval(context);
        }
    }

    public static class OneCharTokenizer implements Tokenizer {
        private final char target;
        private boolean first = true;

        public OneCharTokenizer(char target) {
            this.target = target;
        }

        @Override
        public boolean feed(char c) {
            if (c != target) return false;
            if (!first) return false;
            first = false;
            return true;
        }

        @Override
        public Token end() {
            if (first) throw new RuntimeException("first not feed");
            return null;
        }
    }

    public static class SpaceTokenizer implements Tokenizer {

        @Override
        public boolean feed(char c) {
            if (c == ' ') return true;
            return false;
        }

        @Override
        public Token end() {
            return null;
        }
    }
}
