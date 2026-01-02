package com.yanso.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 固定左边，双指针扫描右侧（易于去重）。
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);

        for (int k = 0; k < nums.length; k++) {
            // 提前结束
            if (nums[k] > 0) break;
            // 去重
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    // 由于可能有重复：
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j] == nums[j - 1]) j--;
                    i++;
                    j--;
                } else if (sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0};
        List<List<Integer>> lists = new ThreeSum().threeSum(nums);
        lists.forEach(list -> System.out.println(Arrays.toString(list.toArray())));
    }
}
