package com.caipeichao.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution808 {
    public double soupServings(int N) {
        if (N == 0) return 0.5;
        if (N > 7000) return 1.0;
        return soupServingsWithCache(N, N);
    }

    private Map<State, Double> cache = new HashMap<>();

    private double soupServingsWithCache(int a, int b) {
        State state = new State(a, b);
        Double result = cache.get(state);
        if (result != null) return result;
        result = soupServingsNoCache(new State(a, b));
        cache.put(state, result);
        return result;
    }

    private double soupServingsNoCache(State state) {
        double r1 = action(state, 100, 0);
        double r2 = action(state, 75, 25);
        double r3 = action(state, 50, 50);
        double r4 = action(state, 25, 75);
        return (r1 + r2 + r3 + r4) / 4;
    }

    private double action(State state, int a, int b) {
        int aBefore = state.a;
        int bBefore = state.b;
        int aAfter = Math.max(0, aBefore - a);
        int bAfter = Math.max(0, bBefore - b);
        boolean aEmpty = aBefore != 0 && aAfter == 0;
        boolean bEmpty = bBefore != 0 && bAfter == 0;
        if (aEmpty && bEmpty) return 0.5;
        if (aEmpty) return 1.0;
        if (bEmpty) return 0.0;
        return soupServingsWithCache(aAfter, bAfter);
    }

    public static class State {
        private final int a;
        private final int b;

        public State(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            return a == state.a &&
                    b == state.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}