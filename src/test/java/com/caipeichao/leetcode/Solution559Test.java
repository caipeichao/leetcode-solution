package com.caipeichao.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Solution559Test {
    @Test
    public void test() {
        Node node010 = new Node();
        Node node01 = new Node();
        node01.children = list(node010);
        Node node00 = new Node();
        Node node0 = new Node();
        node0.children = list(node00, node01);
        System.out.println(new Solution559().maxDepth(node0));
    }

    private List<Node> list(Node... nodes) {
        return new ArrayList<>(Arrays.asList(nodes));
    }
}