package com.yanso.dp;

public class MaxDotProduct {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m][n];
        /**
         * 斜上方代表：“我也要当前这对，并接在前面的结果后面”。
         * 左方/上方代表：“当前这一对里至少有一个我不想要，我直接沿用之前的最优战果”。
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentProduct = nums1[i] * nums2[j];

                // 1. 初始可能：只选当前这一对数（应对前面全是负数的情况）
                dp[i][j] = currentProduct;

                if (i > 0 && j > 0) {
                    // 2. 累加可能：当前乘积 + 前面累积的最大点积
                    // 注意：Math.max(dp[i][j], ...) 确保了如果 dp[i-1][j-1] 是负的，我们宁愿只选 currentProduct
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + currentProduct);
                }

                // 3. 继承可能：从左方或上方继承最大值（即：不一定要包含当前的 nums1[i] 或 nums2[j]）
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[] nums1 = {2,1,-2,5}, nums2 = {3,0,-6};
        int result = new MaxDotProduct().maxDotProduct(nums1, nums2);
        System.out.println("result = " + result);
    }
}
