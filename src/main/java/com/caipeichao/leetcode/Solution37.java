package com.caipeichao.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution37 {
    public void solveSudoku(char[][] board) {
        Board b = Board.parse(board);
        Board result = new SolveSudoku().solve(b);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[j][i] = (char) ('1' + result.get(i, j));
            }
        }
    }

    public static class Board {
        private final Integer[] numbers;

        private Board(Integer[] numbers) {
            assert numbers.length == 81;
            this.numbers = numbers;
        }

        public static Board parse(char[][] board) {
            Integer[] result = new Integer[81];
            int i = 0;
            for (char[] c1 : board) {
                for (char c2 : c1) {
                    result[i++] = parseSudokuNumber(c2);
                }
            }
            Board result2 = new Board(result);
            if (!result2.isValid()) throw new RuntimeException("Invalid board");
            return result2;
        }

        private static Integer parseSudokuNumber(char c) {
            if (c == '.') return null;
            assert '1' <= c && c <= '9';
            return c - '1';
        }

        public boolean isValid() {
            // 检查每一行
            for (int y = 0; y < 9; y++) {
                Validator validator = new Validator();
                for (int x = 0; x < 9; x++) {
                    validator.add(get(x, y));
                }
                if (!validator.isValid()) return false;
            }

            // 检查每一列
            for (int x = 0; x < 9; x++) {
                Validator validator = new Validator();
                for (int y = 0; y < 9; y++) {
                    validator.add(get(x, y));
                }
                if (!validator.isValid()) return false;
            }

            // 检查每个格子
            for (int x1 = 0; x1 < 9; x1 += 3) {
                for (int y1 = 0; y1 < 9; y1 += 3) {
                    Validator validator = new Validator();
                    for (int x2 = 0; x2 < 3; x2++) {
                        for (int y2 = 0; y2 < 3; y2++) {
                            int x = x1 + x2;
                            int y = y1 + y2;
                            validator.add(get(x, y));
                        }
                    }
                    if (!validator.isValid()) return false;
                }
            }

            // 检查通过
            return true;
        }

        public Integer get(int x, int y) {
            return get(Position.create(x, y));
        }

        public Integer get(Position position) {
            return numbers[position.flatten()];
        }

        public ValidPuts getAllValidPutActions() {
            // 默认都可以放
            boolean[][][] valid = new boolean[9][9][9];
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    for (int z = 0; z < 9; z++) {
                        valid[x][y][z] = true;
                    }
                }
            }

            // 去掉不能放的
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    Integer number = get(x, y);
                    if (number == null) continue;
                    int n = number;

                    // 已经放了就不能再放了
                    for (int i = 0; i < 9; i++) {
                        valid[x][y][i] = false;
                    }

                    // 同一行里面已经有了
                    for (int i = 0; i < 9; i++) {
                        valid[i][y][n] = false;
                    }

                    // 同一列里面已经有了
                    for (int i = 0; i < 9; i++) {
                        valid[x][i][n] = false;
                    }

                    // 同一格里面已经有了
                    for (int x2 = 0; x2 < 3; x2++) {
                        for (int y2 = 0; y2 < 3; y2++) {
                            valid[x - x % 3 + x2][y - y % 3 + y2][n] = false;
                        }
                    }
                }
            }

            // 剩下的都是可以放的
            return new ValidPuts(valid);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    Integer n = get(x, y);
                    if (n == null) {
                        result.append(" ");
                    } else {
                        result.append(n + 1);
                    }
                }
                result.append("\n");
            }
            return result.toString();
        }

        public boolean isAllPut() {
            for (Integer e : numbers) {
                if (e == null) return false;
            }
            return true;
        }

        public Board put(int x, int y, Integer number) {
            if (isPut(x, y)) throw new RuntimeException("Already put");
            Integer[] newNumbers = Arrays.copyOf(numbers, numbers.length);
            newNumbers[Position.create(x, y).flatten()] = number;
            return new Board(newNumbers);
        }

        public boolean isPut(int x, int y) {
            return get(x, y) != null;
        }
    }

    public static class OrderByValue implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
            int c = Integer.compare(o1.getValue(), o2.getValue());
            if (c != 0) return c;
            return Integer.compare(o1.getKey(), o2.getKey());
        }
    }

    public static class Position {
        private final int x;
        private final int y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Position fromFlat(int f) {
            assert 0 <= f && f < 81;
            int x = f % 9;
            int y = f / 9;
            return create(x, y);
        }

        public static Position create(int x, int y) {
            assert 0 <= x && x < 9;
            assert 0 <= y && y < 9;
            return new Position(x, y);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int flatten() {
            return y * 9 + x;
        }
    }

    public static class PutAction {
        private final Position position;
        private final int number;

        private PutAction(Position position, int number) {
            this.position = position;
            this.number = number;
        }

        public static PutAction create(Position position, int number) {
            return new PutAction(position, number);
        }

        public Position getPosition() {
            return position;
        }

        public int getNumber() {
            return number;
        }
    }

    public static class SudukuSolution {
        private final boolean found;
        private final Board board;

        public SudukuSolution(boolean found, Board board) {
            this.found = found;
            this.board = board;
        }

        public static SudukuSolution createFound(Board board) {
            return new SudukuSolution(true, board);
        }

        public static SudukuSolution createNotFound() {
            return new SudukuSolution(false, null);
        }

        public boolean found() {
            return found;
        }

        public Board getBoard() {
            return board;
        }
    }

    public static class SolveSudoku {
        private Board solve(Board board) {
            SudukuSolution solution = solve2(board);
            if (!solution.found()) {
                throw new RuntimeException("Not solved");
            }
            return solution.getBoard();
        }

        private SudukuSolution solve2(Board board) {
            // 如果已经放满了，说明已经找到解了
            if (board.isAllPut()) {
                return SudukuSolution.createFound(board);
            }

            // 找出下一步能放的数字
            ValidPuts validPuts = board.getAllValidPutActions();

            // 尚未填写的格子，按能放的数量排序，最少的排前面
            HashMap<Integer, Integer> validCounts = new HashMap<>();
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    if (board.isPut(x, y)) continue;
                    int count = validPuts.getValidCount(x, y);
                    int position = Position.create(x, y).flatten();
                    validCounts.put(position, count);
                }
            }
            Map.Entry<Integer, Integer> firstEntry = validCounts.entrySet().stream().min(new OrderByValue()).orElse(null);

            // 如果发现有一个格子不能放任何东西，就直接判定为无解
            int count = firstEntry.getValue();
            if (count == 0) {
                return SudukuSolution.createNotFound();
            }

            // 将最明确的格子先放下去，如果找到解了那就成功了
            Position position = Position.fromFlat(firstEntry.getKey());
            int x = position.getX();
            int y = position.getY();
            for (int i = 0; i < 9; i++) {
                if (!validPuts.isValid(x, y, i)) continue;
                Board newBoard = board.put(x, y, i);
                SudukuSolution solution = solve2(newBoard);
                if (solution.found()) return solution;
            }

            // 无解
            return SudukuSolution.createNotFound();
        }
    }

    public static class Validator {
        private boolean visit[] = new boolean[9];
        private boolean valid = true;

        public void add(Integer number) {
            if (number == null) return;
            if (visit[number]) {
                valid = false;
                return;
            }
            visit[number] = true;
        }

        public boolean isValid() {
            return valid;
        }
    }

    public static class ValidPuts {
        private final boolean[][][] valid;

        public ValidPuts(boolean[][][] valid) {
            this.valid = valid;
        }

        public int getValidCount(int x, int y) {
            int result = 0;
            for (int i = 0; i < 9; i++) {
                if (valid[x][y][i]) {
                    result++;
                }
            }
            return result;
        }

        public boolean isValid(int x, int y, int i) {
            return valid[x][y][i];
        }
    }
}
