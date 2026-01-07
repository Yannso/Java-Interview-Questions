package com.yanso.traceback;

import java.util.HashMap;
import java.util.Map;

public class CountArrangementTraceBack {

    private Map<Integer, Integer> memo = new HashMap<>();

    public int countArrangement(int n) {
        return dfs(1,0,n);
    }

    private int dfs(int index, int mask, int n) {
        if (index > n) {
            return 1;
        }
        if (memo.containsKey(mask)) {
            return memo.get(mask);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (((mask >> (i - 1)) & 1) == 0 && (i % index == 0 || index % i == 0)) {
                // 使用mask来代替访问数组
                res += dfs(index + 1, mask | (1 << (i - 1)), n);
            }
        }
        memo.put(mask, res);
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        int result = new CountArrangementTraceBack().countArrangement(n);
        System.out.println("result = " + result);
    }
}
