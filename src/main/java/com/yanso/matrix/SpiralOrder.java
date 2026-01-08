package com.yanso.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int[][] directs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        dfs(0,0,0,matrix,directs,visited,result);
        return result;
    }

    private boolean dfs(int x, int y, int dir, int[][] matrix, int[][] directs, boolean[][] visited, List<Integer> result) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || visited[x][y]) return false;
        visited[x][y] = true;
        result.add(matrix[x][y]);
        if (!dfs(x + directs[dir][0], y + directs[dir][1], dir, matrix, directs, visited, result)) {
            int newDir = (dir + 1) % 4;
            dfs(x + directs[newDir][0], y + directs[newDir][1], newDir, matrix, directs, visited, result);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}};
        List<Integer> list = new SpiralOrder().spiralOrder(matrix);
        System.out.println("list = " + list);
    }
}
