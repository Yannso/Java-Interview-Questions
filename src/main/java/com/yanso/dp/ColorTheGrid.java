package com.yanso.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColorTheGrid {

    private List<List<Integer>> allStates;

    private final int MOD = 1000000007;

    // 找出所有合法的单行状态
    void dfs(int index, List<Integer> currentLine, int m) {
        if (index == m) {
            allStates.add(new ArrayList<>(currentLine));
            return;
        }
        for (int color : List.of(0, 1, 2)) { // 红, 绿, 蓝
            if (index > 0 && color == currentLine.get(index - 1)) continue; // 左右去重
            currentLine.add(color);
            dfs(index + 1, currentLine, m);
            currentLine.remove(currentLine.size() - 1);
        }
    }

    public int colorTheGrid(int m, int n) {
        allStates = new ArrayList<>();
        dfs(0, new ArrayList<>(), m);
        System.out.println("allState = " + allStates);
        System.out.println("allStates.size() = " + allStates.size());
        int K = allStates.size();
        List<List<Integer>> nextAllowed = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            nextAllowed.add(new ArrayList<>());
            for (int j = 0; j < K; j++) {
                if (canBeNeighbors(allStates.get(i), allStates.get(j))) {
                    nextAllowed.get(i).add(j);
                }
            }
        }
        System.out.println("nextAllowed = " + nextAllowed);
        // 1. 初始化
        long[][] dp = new long[n][K];

        // 2. 初始状态：矩阵的第一列有K种合法状态
        for (int j = 0; j < K; j++) {
            dp[0][j] = 1;
        }

        // 3. 状态转移：从第二列（i=1）开始
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < K; j++) { // j：当前状态
                for(int pre : nextAllowed.get(j)) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][pre]) % MOD;
                }
            }
        }
        int result = 0;
        for (int j = 0; j < K; j++) {
            result = (int) (result + dp[n - 1][j]) % MOD;
        }
        return result;
    }

    private boolean canBeNeighbors(List<Integer> curStates, List<Integer> canBeStates) {
        int size = curStates.size();
        for (int i = 0; i < size; i++) {
            if (curStates.get(i).equals(canBeStates.get(i))) return false; // 只要有一行颜色相同，就无法放在curStates后面
        }
        return true;
    }

    public static void main(String[] args) {
        int m = 5, n = 1000;
        int colored = new ColorTheGrid().colorTheGrid(m, n);
        System.out.println("colored = " + colored);
    }
}
