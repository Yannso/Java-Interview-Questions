package com.yanso.twopoint;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
    }

    public void moveZeroes(int[] nums) {
        int nextPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nextPos++] = nums[i];
            }
        }
        for (int i = nextPos; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
