package com.yanso.array;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int x = 253;
        int count = new MaxConsecutiveOnes().handler(x);
        System.out.println("MaxConsecutiveOnes = " + count);
    }

    private int handler(int x) {
        // 找到最大连续1的个数
        int maxCount = 0;
        int count = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount,count);
                count = 0;
            }
            x >>= 1;
        }
        return Math.max(maxCount,count);
    }
}
