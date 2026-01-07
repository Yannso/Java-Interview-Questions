package com.yanso.array;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int result = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int totalSum = 0;
        for (int i = 0; i < len; i++) {
            minSum = Math.min(minSum, totalSum);
            totalSum += nums[i];
            result = Math.max(result, totalSum - minSum);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        int result = new MaxSubArray().maxSubArray(nums);
        System.out.println("result = " + result);
    }
}
