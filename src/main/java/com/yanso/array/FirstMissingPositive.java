package com.yanso.array;

public class FirstMissingPositive {

    private void findPos(int[] nums) {
        int n = nums.length;
        // 1 to n+1 没有出现的最小正数肯定在这个范围内
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int targetIndex = nums[i] - 1;
                nums[i] = nums[targetIndex];
                nums[targetIndex] = targetIndex + 1;
            }
        }
    }

    public int firstMissingPositive(int[] nums) {
        findPos(nums);
        // System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,1};
        int result = new FirstMissingPositive().firstMissingPositive(nums);
        System.out.println("result = " + result);
    }
}
