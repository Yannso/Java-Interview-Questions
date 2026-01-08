package com.yanso.matrix;

import java.util.Arrays;

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        // 常量空间优化版本
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowHasZero = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        boolean firstColHasZero = false;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowHasZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetZeroes().setZeroes(matrix);
        System.out.println("Arrays.deepToString(matrix) = " + Arrays.deepToString(matrix));
    }
}
