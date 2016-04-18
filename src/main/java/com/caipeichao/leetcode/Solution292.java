package com.caipeichao.leetcode;

public class Solution292 {
    public boolean canWinNim(int n) {
        boolean[] canWin = new boolean[n + 1];
        canWin[0] = false;
        for (int i = 1; i <= n; i++) {
            canWin[i] = canWin(canWin, i);
        }
        return canWin[n];
    }

    private boolean canWin(boolean[] canWin, int n) {
        if (n <= 3) return true;
        for (int i = 1; i <= 3; i++) {
            if (!canWin[n - i]) {
                return true;
            }
        }
        return false;
    }
}

