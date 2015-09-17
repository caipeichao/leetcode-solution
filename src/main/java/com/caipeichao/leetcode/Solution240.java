package com.caipeichao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 获取长度和宽度
        int width = matrix.length;
        if (width == 0) return false;
        int height = matrix[0].length;
        if (height == 0) return false;

        // 先在这个矩阵画一个对角线，从对角线中取出所有的值
        List<Point> diagonal = drawLine(width, height);
        List<Integer> diagonalValues = new ArrayList<Integer>();
        for (Point e : diagonal) {
            int value = matrix[e.x][e.y];
            diagonalValues.add(value);
        }

        // 沿着对角线进行二分查找，确定要搜的范围
        Return r = bisect(diagonalValues, target);
        if (r.found) {
            return true;
        }
        if (r.to == null) return false;

        // 提取要搜索的范围，分别进行二分查找
        Point toPoint = diagonal.get(r.to);
        List<Integer> vline = getLine(matrix, new Point(toPoint.x, 0), toPoint);
        Return vr = bisect(vline, target);
        if (vr.found) return true;

        List<Integer> hline = getLine(matrix, new Point(0, toPoint.y), toPoint);
        Return hr = bisect(hline, target);
        if (hr.found) return true;

        Point fromPoint = diagonal.get(r.from);
        List<Integer> v2line = getLine(matrix, fromPoint, new Point(fromPoint.x, height - 1));
        Return vr2 = bisect(v2line, target);
        if (vr2.found) return true;

        List<Integer> h2line = getLine(matrix, fromPoint, new Point(width - 1, fromPoint.y));
        Return hr2 = bisect(h2line, target);
        if (hr2.found) return true;

        return false;
    }

    public Return bisect(List<Integer> list, int target) {
        int start = 0;
        int end = list.size();
        while (true) {
            int length = end - start;
            if (length < 5) {
                for (int i = start; i < end; i++) {
                    int e = list.get(i);
                    if (e == target) {
                        return found();
                    }
                    if (e > target) {
                        return notFound(i - 1, i);
                    }
                }
                return notFound(end - 1, null);
            }
            int mid = (length - 1) / 2;
            int midNum = list.get(mid);
            if (midNum < target) {
                start = mid;
            } else if (target < midNum) {
                end = mid + 1;
            } else {
                return found();
            }
        }
    }

    private Return found() {
        Return r = new Return();
        r.found = true;
        return r;
    }

    private Return notFound(Integer from, Integer to) {
        Return r = new Return();
        r.from = from;
        r.to = to;
        return r;
    }

    public List<Integer> getLine(int[][] matrix, Point from, Point to) {
        List<Integer> result = new ArrayList<Integer>();
        if (from.x == to.x) {
            for (int y = from.y; y <= to.y; y++) {
                int x = from.x;
                result.add(matrix[x][y]);
            }
            return result;
        } else {
            for (int x = from.x; x <= to.x; x++) {
                int y = from.y;
                result.add(matrix[x][y]);
            }
            return result;
        }
    }

    private static class Return {
        public boolean found;
        public Integer from;
        public Integer to;
    }

    public List<Point> drawLine(int width, int height) {
        // 要求宽度大于长度，否则调换宽度和长度，然后翻转结果
        if (width < height) {
            List<Point> line = drawLine(height, width);
            List<Point> result = new ArrayList<Point>();
            for (Point e : line) {
                result.add(new Point(e.y, e.x));
            }
            return result;
        }

        // 返回结果
        List<Point> result = new ArrayList<Point>();
        for (int x = 0; x < width; x++) {
            float percent = ((float) x + 0.25f) / width;
            int y = (int) (height * percent);
            result.add(new Point(x, y));
        }
        return result;
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
