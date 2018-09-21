package com.caipeichao.leetcode;

import java.util.function.Predicate;

public class Solution297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";
            return root.val + encode(root.left, root.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return decode(data);
        }

        private TreeNode decode(String data) {
            return decode(new StringReader(data));
        }

        private TreeNode decode(StringReader data) {
            return data.readNode();
        }

        private String encode(TreeNode left, TreeNode right) {
            if (left == null && right == null) return "";
            return "(" + serialize(left) + "," + serialize(right) + ")";
        }
    }

    class StringReader {
        private String data;
        private int pointer;

        public StringReader(String data) {
            this.data = data;
        }

        public Character read() {
            if (pointer >= data.length()) return null;
            return data.charAt(pointer++);
        }

        public int mark() {
            return pointer;
        }

        public void reset(int pointer) {
            this.pointer = pointer;
        }

        public TreeNode readNode() {
            Integer x = readInt();
            if (x == null) return null;
            TreeNode result = new TreeNode(x);
            LeftAndRight lr = readLeftAndRight();
            if (lr != null) {
                result.left = lr.left;
                result.right = lr.right;
            }
            return result;
        }

        public Integer readInt() {
            StringBuilder s = new StringBuilder();
            while (true) {
                Character c = readDigitChar();
                if (c == null) break;
                s.append(c);
            }
            if (s.length() == 0) return null;
            return Integer.parseInt(s.toString());
        }

        public Character readDigitChar() {
            return readThat(this::isDigit);
        }

        private LeftAndRight readLeftAndRight() {
            Character c = readThat(x -> x == '(');
            if (c == null) return null;
            TreeNode left = readNode();
            c = readThat(x -> x == ',');
            if (c == null) throw new RuntimeException("no comma found");
            TreeNode right = readNode();
            c = readThat(x -> x == ')');
            if (c == null) throw new RuntimeException("no right bracket found");
            return new LeftAndRight(left, right);
        }

        private Character readThat(Predicate<Character> predicate) {
            int p = mark();
            Character c = read();
            if (c == null) return null;
            if (!predicate.test(c)) {
                reset(p);
                return null;
            }
            return c;
        }

        private boolean isDigit(char c) {
            return ('0' <= c && c <= '9') || c == '-';
        }
    }

    class LeftAndRight {
        public TreeNode left;
        public TreeNode right;

        public LeftAndRight(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
}