package com.yanso.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] - nums[i-1] == 1) {
                max++;
            } else if (nums[i] - nums[i-1] > 1) {
                longest = Math.max(longest, max);
                max = 1;
            }
        }
        return Math.max(longest, max);
    }

    public int longestConsecutiveHash(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // Set<Integer> num_set = new HashSet<>(Arrays.stream(nums).boxed().toList());
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longest = 0;
        // 枚举每个可能的起点，然后向前遍历，判断连续数字是否存在于集合
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentCount = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentCount++;
                }

                longest = Math.max(longest, currentCount);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int res = new LongestConsecutive().longestConsecutiveHash(nums);
        System.out.println("res = " + res);
    }
}
