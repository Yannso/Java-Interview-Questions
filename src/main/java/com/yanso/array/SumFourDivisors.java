package com.yanso.array;

public class SumFourDivisors {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            // num 的因数至少为 1 和 num 自身
            int count = 0;
            int currentSum = 0;
            for (int x = 1; x * x <= num; x++) {
                if (num % x == 0) {
                    count++;
                    currentSum += x;
                    int y = num / x;
                    if (x != y) {
                        count++;
                        currentSum += y;
                    }
                    if (count > 4) break;
                }
            }
            if (count == 4) totalSum += currentSum;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int[] nums = {7286,18704,70773,8224,91675};
        int result = new SumFourDivisors().sumFourDivisors(nums);
        System.out.println("result = " + result);
    }
}
