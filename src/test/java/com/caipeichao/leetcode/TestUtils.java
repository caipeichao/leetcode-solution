package com.caipeichao.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
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
}
