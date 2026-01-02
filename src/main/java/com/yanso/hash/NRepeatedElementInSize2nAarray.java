package com.yanso.hash;

import java.util.HashSet;

public class NRepeatedElementInSize2nAarray {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {9,5,3,3};
        int result = new NRepeatedElementInSize2nAarray().repeatedNTimes(testArray);
        System.out.println("The repeated element is: " + result);
    }
}
