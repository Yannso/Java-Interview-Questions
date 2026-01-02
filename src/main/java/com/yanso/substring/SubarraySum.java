package com.yanso.substring;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // prefixSum[i] = 前 i 个元素之和，0 到 i - 1
        for (int num : nums) {
            preSum += num;
            count += map.getOrDefault(preSum - k,0);
            map.put(preSum, map.getOrDefault(preSum,0) + 1);

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        System.out.println(new SubarraySum().subarraySum(nums, k));
    }
}
