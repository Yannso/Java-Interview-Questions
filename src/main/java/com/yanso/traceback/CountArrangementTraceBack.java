package com.yanso.traceback;

public class CountArrangementTraceBack {
    private int count;
    private boolean[] visited;

    public int countArrangement(int n) {
        count = 0;
        visited = new boolean[n + 1];
        dfs(1, n);
        return count;
    }

    private void dfs(int index, int n) {
        if (index > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                visited[i] = true;
                dfs(index + 1, n);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int result = new CountArrangementTraceBack().countArrangement(n);
        System.out.println("result = " + result);
    }
}
