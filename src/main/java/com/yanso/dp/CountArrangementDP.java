package com.yanso.dp;

public class CountArrangementDP {
    public int countArrangement(int n) {
        int maskTotal = 1 << n;
        // 枚举mask， mask从 0 到 2 ^ n - 1
        int[] dp = new int[maskTotal];
        dp[0] = 1;
        for (int mask = 0; mask < maskTotal; mask++) {
            // 1. 根据当前 mask 里的 1 的个数，确定我们要填第几个坑
            int index = Integer.bitCount(mask) + 1;
            // 2. 根据当前坑位，确定当前数字是否可以填入
            for (int num = 1; num <= n; num++) {
                // 3.1 当前数字必须没选取过
                // 3.2 当前数字满足优美排列的要求
                if (((mask >> (num - 1)) & 1) == 0 && (num % index == 0 || index % num == 0)) {
                    dp[1 << (num - 1) | mask] += dp[mask];
                }
            }
        }
        return dp[maskTotal - 1];
    }

    public static void main(String[] args) {
        int n = 3;
        int result = new CountArrangementDP().countArrangement(n);
        System.out.println("result = " + result);
    }
}
