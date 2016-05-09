package com.caipeichao.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TestUtils {
    public static String toString(List<List<Integer>> list) {
        StringBuilder result = new StringBuilder();
        for (List<Integer> e : list) {
            for (Integer e2 : e) {
                result.append(e2);
            }
            result.append(",");
        }
        return result.toString();
    }

    public static String toString(boolean[] b) {
        StringBuilder result = new StringBuilder();
        for (boolean e : b) {
            if (e) {
                result.append("T");
            } else {
                result.append("F");
            }
        }
        return result.toString();
    }

    public static String toString2(List<Integer> list) {
        StringBuilder result = new StringBuilder();
        for (Integer e : list) {
            result.append(e);
        }
        return result.toString();
    }

    public static String toString(int[] b) {
        StringBuilder result = new StringBuilder();
        for (int e : b) {
            result.append(e);
        }
        return result.toString();
    }

    public static String toString2(int[] b) {
        if (b.length == 0) return "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            int e = b[i];
            result.append(i);
            result.append(":");
            result.append(e);
            result.append(",");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public static int[] parseIntArray(String input) {
        String[] a = input.split(",");
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = Integer.parseInt(a[i]);
        }
        return result;
    }

    public static String toStringListTreeNode(List<TreeNode> nodes) {
        List<String> result = new ArrayList<String>();
        for (TreeNode node : nodes) {
            result.add(toString(node));
        }
        return JSON.toJSONString(result);
    }

    public static String toString(TreeNode node) {
        if (node == null) return "{#}";

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        List<String> result = new ArrayList<String>();
        while (!queue.isEmpty()) {
            TreeNode head = queue.pollFirst();
            if (head != null) {
                result.add(Integer.toString(head.val));
                queue.add(head.left);
                queue.add(head.right);
            } else {
                result.add("#");
            }
        }
        return "{" + StringUtils.join(result, ",") + "}";
    }

    public static int[] parseJsonArray(String input) {
        JSONArray a = JSON.parseArray(input);
        int[] result = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            result[i] = a.getIntValue(i);
        }
        return result;
    }

    public static String toJsonString(Object e) {
        return JSON.toJSONString(e);
    }

    public static List<List<Integer>> parseJsonListList(String s) {
        return (List) JSON.parseArray(s);
    }

    public static ListNode parseLinkedList(String input) {
        List<Integer> list = (List) JSON.parseArray(input);
        ListNode head = null;
        ListNode tail = null;
        for (int e : list) {
            ListNode newNode = new ListNode(e);
            if (tail != null) tail.next = newNode;
            tail = newNode;
            if (head == null) head = tail;
        }
        return head;
    }

    public static String toStringListNode(ListNode head) {
        List<Integer> result = new ArrayList<Integer>();
        ListNode node = head;
        while (node != null) {
            result.add(node.val);
            node = node.next;
        }
        return JSON.toJSONString(result);
    }

    public static int[][] parseIntGrid(String input) {
        List<List<Integer>> list = (List) JSON.parseArray(input);
        int width = list.size();
        int height = list.get(0).size();
        int[][] result = new int[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                result[x][y] = list.get(x).get(y);
            }
        }
        return result;
    }

    public static TreeNode parseTreeNode(String input) {
        // 解析json
        JSONArray a = JSON.parseArray(input);
        Iterator<Object> iter = a.iterator();
        if (!iter.hasNext()) return null;

        // 生成根节点
        TreeNode root = pollTreeNode(iter);
        if (!iter.hasNext()) return root;

        // 分层解析
        List<TreeNode> thisLayer = new ArrayList<TreeNode>();
        thisLayer.add(root);
        List<TreeNode> nextLayer = new ArrayList<TreeNode>();

        // 解析当前层
        while (true) {
            for (TreeNode node : thisLayer) {
                if (node == null) continue;
                node.left = pollTreeNode(iter);
                nextLayer.add(node.left);
                if (!iter.hasNext()) return root;
                node.right = pollTreeNode(iter);
                nextLayer.add(node.right);
                if (!iter.hasNext()) return root;
            }
            if (nextLayer.isEmpty()) return root;
            thisLayer = nextLayer;
            nextLayer = new ArrayList<TreeNode>();
        }
    }

    private static TreeNode pollTreeNode(Iterator<Object> iter) {
        if (!iter.hasNext()) return null;
        Object e = iter.next();
        if (e == null) return null;
        return new TreeNode((Integer) e);
    }

    public static String encodeIntArrayArray(int[][] board) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (int[] e : board) {
            if (first) first = false;
            else result.append(";");
            boolean first2 = true;
            for (int e2 : e) {
                if (first2) first2 = false;
                else result.append(",");
                result.append(e2);
            }
        }
        return result.toString();
    }

    public static int[][] decodeIntArrayArray(String board) {
        String[] split = board.split(";");
        int[][] result = new int[split.length][];
        for (int i = 0; i < result.length; i++) {
            String e = split[i];
            String[] split2 = e.split(",");
            result[i] = new int[split2.length];
            for (int j = 0; j < result[i].length; j++) {
                String e2 = split2[j];
                result[i][j] = Integer.parseInt(e2);
            }
        }
        return result;
    }

    public static String encodeIntArray(int[] a) {
        return null;
    }

    public static int[] decodeIntArray(int[] a) {
        return null;
    }

    public static String encodeIntList(List<Integer> a) {
        return null;
    }

    public static List<Integer> decodeIntList(String a) {
        return null;
    }

    public static String encodeTreeNode(TreeNode node) {
        return null;
    }

    public static TreeNode decodeTreeNode(String s) {
        return null;
    }

    public static String encodeBoolArray(boolean[] a) {
        return null;
    }

    public static boolean[] decodeBoolArray(String a) {
        return null;
    }

    public static String encodeTreeNodeList(List<TreeNode> a) {
        return null;
    }

    public static List<TreeNode> decodeTreeNodeList(String a) {
        return null;
    }
}
