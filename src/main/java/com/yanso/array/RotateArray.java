package com.yanso.array;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] copy = new int[len - k];
        System.arraycopy(nums,0,copy,0,len - k);
        for (int i = 0; i < k; i++) {
            nums[i] = nums[len - k + i];
        }
        System.arraycopy(copy,0,nums,k,len - k);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        new RotateArray().rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
