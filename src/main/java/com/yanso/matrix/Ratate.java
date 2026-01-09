package com.yanso.matrix;

import java.util.Arrays;

public class Ratate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 第i行变成第n-i列
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                // [i,j] ->
                // [j, n - i - 1]  第二个位置
                // [n - i - 1, n - j -1] 第三个位置
                //  [n - j -1, i] 第四个位置
                matrix[i][j] = matrix[n - j - 1][i]; // 第四个位置到第一个位置
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Ratate().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
