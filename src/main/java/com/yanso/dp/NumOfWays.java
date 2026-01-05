package com.yanso.dp;

public class NumOfWays {
    static int MOD = 1000000007;
    public int numOfWays(int n) {
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 6;
        for (int i = 1; i < n; i++) {
            // 使用 long 类型承接中间计算结果
            long aba = dp[i - 1][0]; // 可以提供3个ABA方案，2个ABC方案
            long abc = dp[i - 1][1]; // 可以提供2个ABA方案，2个ABC方案

            dp[i][0] = (int) ((aba * 3 + abc * 2) % MOD);
            dp[i][1] = (int) ((aba * 2 + abc * 2) % MOD);
        }
        return (dp[n - 1][0] + dp[n - 1][1]) % MOD;
    }

    public static void main(String[] args) {
        int n = 5000;
        int result = new NumOfWays().numOfWays(n);
        System.out.println("result = " + result);

    }
}
