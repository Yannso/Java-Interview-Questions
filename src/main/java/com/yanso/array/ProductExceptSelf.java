package com.yanso.array;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // 不可以使用除法
        int n = nums.length;
        int[] result = new int[n];
        int[] leftProduct = new int[n + 1];
        int[] rightProduct = new int[n + 1];
        leftProduct[0] = rightProduct[n] = 1;
        for (int i = 0; i < n; i++) {
            leftProduct[i + 1] = leftProduct[i] * nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i];
        }
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct[i] * rightProduct[i + 1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3 ,4};
        int[] result = new ProductExceptSelf().productExceptSelf(nums);
        System.out.println("result = " + Arrays.toString(result));
    }
}
