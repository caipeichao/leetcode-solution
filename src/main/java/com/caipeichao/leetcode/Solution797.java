package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(root());
        return allPathsForNode(graph, result);
    }

    private List<Integer> root() {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        return result;
    }

    private List<List<Integer>> allPathsForNode(int[][] graph, List<List<Integer>> paths) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isAllTarget = true;
        for (List<Integer> path : paths) {
            if (expandPath(graph, path, result)) {
                isAllTarget = false;
            }
        }
        if (isAllTarget) return result;
        return allPathsForNode(graph, result);
    }

    private boolean expandPath(int[][] graph, List<Integer> path, List<List<Integer>> result) {
        int node = last(path);
        if (node == graph.length - 1) {
            result.add(path);
            return false;
        }
        for (int e : graph[node]) {
            result.add(copyAndAppend(path, e));
        }
        return true;
    }

    private int last(List<Integer> path) {
        return path.get(path.size() - 1);
    }

    private List<Integer> copyAndAppend(List<Integer> path, int value) {
        List<Integer> result = new ArrayList<>(path);
        result.add(value);
        return result;
    }
}
