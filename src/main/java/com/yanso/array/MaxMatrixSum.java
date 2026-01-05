package com.yanso.array;

public class MaxMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        // 如果是奇数个负号，那么会剩下一个负号无法消除，此时将负号转移到绝对值最小元素即可
        int negtiveCount = 0;
        long sum = 0;
        int absMinValue = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0) {
                    negtiveCount++;
                }
                absMinValue = Math.min(absMinValue, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }
        if (negtiveCount % 2 == 1) {
            return sum - absMinValue - absMinValue;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-1,-0,-1}, {-2,1,3}, {3,2,2}};
        System.out.println("result = " +
                new MaxMatrixSum().maxMatrixSum(matrix));
    }
}
